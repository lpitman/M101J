package com.Stompy;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by Logan on 06/08/2014.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args){
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World From Spark";
            }
        });
    }
}
