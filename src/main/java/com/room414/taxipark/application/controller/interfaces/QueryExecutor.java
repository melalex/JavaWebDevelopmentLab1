package com.room414.taxipark.application.controller.interfaces;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.view.interfaces.View;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Base class to query execute strategies.
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public abstract class QueryExecutor {
    protected Query query;
    protected View view;

    public void setQuery(Query query) {
        this.query = query;
    }

    /**
     * Template method.
     */
    public void complete() {
        if (prepare()) {
            execute();
            render();
        } else {
            renderErrors();
        }
    }

    /**
     * Show result of query on View.
     */
    protected void render() {
        view.renderLine("OK");
    }

    /**
     * Show errors on View.
     */
    protected void renderErrors() {
        view.renderLine("Cannot process the request: " + query.toString());
    }

    /**
     * Prepare query for executing (validation, casting).
     *
     * @return is query valid
     */
    protected boolean prepare() {
        return false;
    }

    /**
     * Executes query.
     */
    protected void execute() {
        throw new NotImplementedException();
    }
}
