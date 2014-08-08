package com.Stompy;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Logan on 08/08/2014.
 */
public class HelloWorldMongoDBSparkFreemarkerStyle{
    public static void main(String[] args) throws UnknownHostException{
        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(
                HelloWorldMongoDBSparkFreemarkerStyle.class, "/");

        MongoClient client = new MongoClient(new ServerAddress("173.212.77.18", 27017));

        DB database = client .getDB("course");
        final DBCollection collection = database.getCollection("hello");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = config.getTemplate("hello.ftl");

                    DBObject document = collection.findOne();

                    helloTemplate.process(document, writer);
                    System.out.println(writer);

                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });
    }
}

