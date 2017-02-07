package com.room414.taxipark.application.controller.infrastucture;

/**
 * Created by melalex on 2/7/17.
 */
public enum QueryType {
    INVALID {
        @Override
        public String getQuery(){
            return "";
        }
    },
    CREATE_CAR {
        @Override
        public String getQuery(){
            return "CREATE CAR";
        }
    },
    CREATE_PARK {
        @Override
        public String getQuery(){
            return "CREATE PARK";
        }
    },
    FIND_ALL_CARS{
        @Override
        public String getQuery(){
            return "ALL CAR";
        }
    },
    FIND_ALL_PARKS {
        @Override
        public String getQuery(){
            return "ALL PARK";
        }
    },
    GET_CAR {
        @Override
        public String getQuery(){
            return "GET CAR";
        }
    },
    GET_PARK {
        @Override
        public String getQuery(){
            return "GET PARK";
        }
    },
    UPDATE_CAR {
        @Override
        public String getQuery(){
            return "UPDATE CAR";
        }
    },
    UPDATE_PARK {
        @Override
        public String getQuery(){
            return "UPDATE PARK";
        }
    },
    DELETE_CAR {
        @Override
        public String getQuery(){
            return "DELETE CAR";
        }
    },
    DELETE_PARK {
        @Override
        public String getQuery(){
            return "DELETE PARK";
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
