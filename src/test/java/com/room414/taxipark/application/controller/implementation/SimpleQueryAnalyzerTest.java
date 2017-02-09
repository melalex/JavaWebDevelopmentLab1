package com.room414.taxipark.application.controller.implementation;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class SimpleQueryAnalyzerTest {
    @Test
    void analyzeValid() {
        String queryFormat = "%s %s:%s %s:%s %s:%s";
        String argumentName1 = "ARG1";
        String argumentName2 = "ARG2";
        String argumentName3 = "ARG3";
        String argumentValue1 = "val1";
        String argumentValue2 = "val2";
        String argumentValue3 = "val3";
        LinkedList<String> queriesStrings = new LinkedList<>();
        QueryType[] queryTypes = QueryType.values();
        for (int i = 1; i < queryTypes.length; i++) {
            queriesStrings.addLast(String.format(
                    queryFormat,
                    queryTypes[i].getQuery(),
                    argumentName1,
                    argumentValue1,
                    argumentName2,
                    argumentValue2,
                    argumentName3,
                    argumentValue3
            ));
        }

        SimpleQueryAnalyzer analyzer = new SimpleQueryAnalyzer();
        Query query;

        for (int i = 0; i < queriesStrings.size(); i++) {
            query = analyzer.analyze(queriesStrings.get(i));

            assert query.getQueryType() == queryTypes[i + 1];
            assert query.argumentsCount() == 3;
            assert query.getArgument(argumentName1).equals(argumentValue1);
            assert query.getArgument(argumentName2).equals(argumentValue2);
            assert query.getArgument(argumentName3).equals(argumentValue3);
        }
    }

    @Test
    void analyzeInvalid() {
        String query1 = "qwe asd:asd asd:asd asd:asd";
        String query2 = "COST asd asd asd";
        String query3 = "COST asd:asd asa asd:asd";
        SimpleQueryAnalyzer analyzer = new SimpleQueryAnalyzer();

        Query query = analyzer.analyze(query1);
        assert query.getQueryType() == QueryType.INVALID;

        query = analyzer.analyze(query2);
        assert query.getQueryType() == QueryType.INVALID;

        query = analyzer.analyze(query3);
        assert query.getQueryType() == QueryType.INVALID;
    }
}