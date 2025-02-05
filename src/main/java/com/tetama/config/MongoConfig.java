package com.example.tetama.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {
  private static final MongoClient mongoClient;

  static {
    try {
      // Connect to MongoDB running in Docker
      mongoClient = MongoClients.create("mongodb://localhost:27017");
    } catch (Exception e) {
      throw new RuntimeException("Failed to connect to MongoDB", e);
    }
  }

  public static MongoClient getMongoClient() {
    return mongoClient;
  }
}