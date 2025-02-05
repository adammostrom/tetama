package com.example.tetama.managers;


import com.example.tetama.config.MongoConfig;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
public class MongoConnectionManager {
  MongoClient mongoClient;
  MongoDatabase database;

  public MongoConnectionManager(String dbName) {
    mongoClient = MongoConfig.getMongoClient();
    database = mongoClient.getDatabase(dbName);
  }

  public MongoDatabase getDatabase() {
    return database;
  }

  public void close() {
    mongoClient.close();
  }


}
