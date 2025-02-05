package com.example.tetama.transformers;

import com.example.tetama.Board;
import com.example.tetama.Task;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.Document;
public class DocumentTransformer {

  /**
   * This function takes in an object of type Task and returns an object of type Document.
   * This is used to store documents in mongodb.
   *
   * @param task The task to create a document for.
   * @return Returns the document, ready to be placed in the mongodb.
   */
  public static Document TaskToDocument(Task task) {
    return new Document("id", task.getId())
        .append("Description", task.getDescription())
        .append("Label", task.getLabel())
        .append("Priority", task.getPrio())
        .append("Date", task.getDate());
  }

  public static Task TaskFromDocument(Document doc) {
    return null; // TODO
  }


  public static Document BoardToDocument(Board board) {
    List<Document> taskDocs = board.getTasks().stream()
        .map(DocumentTransformer::TaskToDocument)
        .collect(Collectors.toList());

    return new Document()
        .append("Name", board.getName())
        .append("Tasks", taskDocs);
        //.append("CreatedDate", board.getCreatedDate()); TODO CREATED DATE
  }

  public static Board BoardFromDocument(Document doc) {
    // TODO: Implement board parsing from Document
    return null;
  }



}
