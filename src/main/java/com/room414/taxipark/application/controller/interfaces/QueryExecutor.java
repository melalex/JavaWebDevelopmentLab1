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

    public void renderErrors() {

    }

    public abstract boolean isValid();
    public abstract void execute();
    public abstract void render();
}
