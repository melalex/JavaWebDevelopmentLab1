package com.room414.taxipark.application.controller.interfaces;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Created by melalex on 2/7/17.
 */
public abstract class QueryExecutor {
    protected Query query;
    protected View view;

    public void setQuery(Query query) {
        this.query = query;
    }

    public void complete() {
        if (prepare()) {
            execute();
            render();
        } else {
            renderErrors();
        }
    }

    protected void render() {
        view.renderMessage("OK");
    }

    protected void renderErrors() {
        view.renderMessage("Cannot process the request: " + query.toString());
    }

    protected abstract boolean prepare();
    protected abstract void execute();
}
