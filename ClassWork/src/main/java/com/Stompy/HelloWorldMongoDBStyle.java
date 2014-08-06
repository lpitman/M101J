package com.Stompy;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by Logan on 06/08/2014.
 */
public class HelloWorldMongoDBStyle {
    public static void main(String[] args) throws UnknownHostException{
        MongoClient client = new MongoClient(new ServerAddress("173.212.77.18", 27017));

        DB database = client .getDB("course");
        DBCollection collection = database.getCollection("hello");

        DBObject document = collection.findOne();
        System.out.println(document);
    }
}
