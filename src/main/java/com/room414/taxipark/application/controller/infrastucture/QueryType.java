package com.room414.taxipark.application.controller.infrastucture;

/**
 * Created by melalex on 2/7/17.
 */
public enum QueryType {
    INVALID {
        @Override
        public String getQuery(){
            return "INVALID";
        }
    },
    CREATE_CAR {
        @Override
        public String getQuery(){
            return "CREATE_CAR";
        }
    },
    CREATE_PARK {
        @Override
        public String getQuery(){
            return "CREATE_PARK";
        }
    },
    FIND_ALL_CARS{
        @Override
        public String getQuery(){
            return "ALL_CARS";
        }
    },
    FIND_ALL_PARKS {
        @Override
        public String getQuery(){
            return "ALL_PARKS";
        }
    },
    GET_CAR {
        @Override
        public String getQuery(){
            return "GET_CAR";
        }
    },
    GET_PARK {
        @Override
        public String getQuery(){
            return "GET_PARK";
        }
    },
    DELETE_CAR {
        @Override
        public String getQuery(){
            return "DELETE_CAR";
        }
    },
    DELETE_PARK {
        @Override
        public String getQuery(){
            return "DELETE_PARK";
        }
    },
    CARS_COST {
        @Override
        public String getQuery(){
            return "COST";
        }
    },
    CONSUMPTION {
        @Override
        public String getQuery(){
            return "CONSUMPTION";
        }
    },
    SPEED {
        @Override
        public String getQuery(){
            return "SPEED";
        }
    };

    public abstract String getQuery();
}
