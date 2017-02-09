package com.room414.taxipark.application.controller.infrastucture;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by melalex on 2/6/17.
 */
public class Query {
    public static class QueryBuilder {
        private QueryType queryType;
        private Map<String, String> arguments = new HashMap<>();
        private String stringRepresentation;

        private QueryBuilder() {

        }

        public QueryBuilder setQueryType(QueryType queryType) {
            this.queryType = queryType;
            return this;
        }

        public QueryBuilder setArgument(String name, String value) {
            arguments.put(name, value);
            return this;
        }

        public QueryBuilder setStringRepresentation(String stringRepresentation) {
            this.stringRepresentation = stringRepresentation;
            return this;
        }

        public Query build() {
            Query query = new Query();

            query.queryType = this.queryType;
            query.arguments = this.arguments;
            query.stringRepresentation = this.stringRepresentation;

            return query;
        }
    }

    private QueryType queryType;
    private Map<String, String> arguments;
    private String stringRepresentation;

    private Query() {

    }

    public static QueryBuilder queryBuilder() {
        return new QueryBuilder();
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public String getArgument(String name) {
        return arguments.get(name);
    }

    public String getArgumentOrDefault(String name, String defaultValue) {
        return arguments.getOrDefault(name, defaultValue);
    }

    public Set<String> argumentsNames() {
        return arguments.keySet();
    }

    public int argumentsCount() {
        return arguments.size();
    }

    @Override
    public String toString() {
        if (stringRepresentation != null) {
            return stringRepresentation;
        } else {
            return super.toString();
        }
    }
}