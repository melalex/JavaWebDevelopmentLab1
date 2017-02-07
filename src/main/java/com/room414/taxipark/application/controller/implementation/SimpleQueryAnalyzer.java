package com.room414.taxipark.application.controller.implementation;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryAnalyzer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by melalex on 2/7/17.
 */
class SimpleQueryAnalyzer implements QueryAnalyzer {
    private static final Map<String, QueryType> types = new HashMap<String, QueryType>() {{
        for (QueryType type: QueryType.values()) {
            put(type.getQuery(), type);
        }
    }};

    private static final Pattern queryPattern = Pattern.compile(
            String.format("^(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s) " +
                    "(\\s\\w+\\s?:\\s?\\w+)$",
                    QueryType.CREATE_CAR,
                    QueryType.CREATE_PARK,
                    QueryType.FIND_ALL_CARS,
                    QueryType.FIND_ALL_PARKS,
                    QueryType.GET_CAR,
                    QueryType.GET_PARK,
                    QueryType.UPDATE_CAR,
                    QueryType.UPDATE_PARK,
                    QueryType.DELETE_CAR,
                    QueryType.DELETE_PARK,
                    QueryType.CARS_COST,
                    QueryType.SPEED,
                    QueryType.CONSUMPTION
            ),
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern argumentPattern = Pattern.compile("^\\s\\w+\\s?:\\s?\\w+$");

    private QueryType queryType(String query) {
        Set<String> queryStrings = types.keySet();
        QueryType result = QueryType.INVALID;
        for (String queryString: queryStrings) {
            if (query.startsWith(queryString)) {
                result = types.get(queryString);
                break;
            }
        }
        return result;
    }

    @Override
    public Query analyze(String query) {
        String normalizedQuery = query.trim();
        Query.QueryBuilder builder = Query.queryBuilder();

        if (queryPattern.matcher(normalizedQuery).matches()) {
            builder.setQueryType(queryType(normalizedQuery));
            Matcher matcher = argumentPattern.matcher(normalizedQuery);
            String[] arguments;

            for (int i = 0, groupCount = matcher.groupCount(); i < groupCount; i++) {
                arguments = matcher.group(i).split(":");
                builder.setArgument(arguments[0].trim().toUpperCase(), arguments[1].trim());
            }
        } else {
            builder.setQueryType(QueryType.INVALID);
        }

        return builder.build();
    }
}
