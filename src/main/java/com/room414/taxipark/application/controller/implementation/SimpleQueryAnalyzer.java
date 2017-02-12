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
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
class SimpleQueryAnalyzer implements QueryAnalyzer {
    private static final Map<String, QueryType> types = new HashMap<>();

    static {
        for (QueryType type: QueryType.values()) {
            types.put(type.getQuery(), type);
        }
    }

    private static final Pattern queryPattern = Pattern.compile(
            String.format("^((%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s)|(%s))" +
                    "(\\s+\\w+\\s*:\\s*\\w+)*$",
                    QueryType.CREATE_CAR.getQuery(),
                    QueryType.CREATE_PARK.getQuery(),
                    QueryType.FIND_ALL_CARS.getQuery(),
                    QueryType.FIND_ALL_PARKS.getQuery(),
                    QueryType.GET_CAR.getQuery(),
                    QueryType.GET_PARK.getQuery(),
                    QueryType.DELETE_CAR.getQuery(),
                    QueryType.DELETE_PARK.getQuery(),
                    QueryType.CARS_COST.getQuery(),
                    QueryType.SPEED.getQuery(),
                    QueryType.CONSUMPTION.getQuery()
            ),
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern argumentPattern = Pattern.compile("\\s+\\w+\\s*:\\s*\\w+");

    private QueryType queryType(String query) {
        String ignoreCase = query.toUpperCase();
        Set<String> queryStrings = types.keySet();
        QueryType result = QueryType.INVALID;
        for (String queryString: queryStrings) {
            if (ignoreCase.startsWith(queryString.toUpperCase())) {
                result = types.get(queryString);
                break;
            }
        }
        return result;
    }

    @Override
    public Query analyze(String query) {
        String normalizedQuery = query.trim();
        Query.QueryBuilder builder = Query
                .queryBuilder()
                .setStringRepresentation(query);

        if (queryPattern.matcher(normalizedQuery).matches()) {
            builder.setQueryType(queryType(normalizedQuery));
            Matcher matcher = argumentPattern.matcher(normalizedQuery);
            String[] arguments;
            while (matcher.find()) {
                arguments = matcher.group(0).split(":");
                builder.setArgument(arguments[0].trim().toUpperCase(), arguments[1].trim());
            }
        } else {
            builder.setQueryType(QueryType.INVALID);
        }

        return builder.build();
    }
}
