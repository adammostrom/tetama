package com.example.tetama.services;

import com.example.tetama.Board;
import com.example.tetama.Task;
import com.example.tetama.managers.MongoConnectionManager;
import com.example.tetama.transformers.DocumentTransformer;
import com.mongodb.client.MongoCollection;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class DatabaseService {



  /** Connection manager that initiates the database */
  MongoConnectionManager mongoManager;

  /** Mongo collection which corresponds to the database collection */
  private final MongoCollection<Document> collection;

  /** Format for date */
  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");


  String dbName = "tetama_database";
  String collectionName = "tetama_tasks";

  public DatabaseService() {
    this.mongoManager = new MongoConnectionManager(dbName);
    this.collection = mongoManager.getDatabase().getCollection(collectionName);
  }

  public void insertTask(Task task) {
    Document doc = DocumentTransformer.TaskToDocument(task);
    collection.insertOne(doc);
  }

  public void storeBoard(Board board){
    Document doc = DocumentTransformer.BoardToDocument(board);
    collection.insertOne(doc);
  }

  public List<Board> getAllBoards() {
    List<Board> boards = new ArrayList<>();
    for (Document doc : collection.find()) {
      Board board = DocumentTransformer.BoardFromDocument(doc); // Assuming this method converts a Document to a Board
      boards.add(board);
    }
    return boards;
  }
}
