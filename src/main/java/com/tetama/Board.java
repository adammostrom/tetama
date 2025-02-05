package com.example.tetama;
import java.util.List;
import java.util.ArrayList;

public class Board {


  public List <Task> tasks;

  public int lastAssignedId;

  public List <Integer> ids;

  public String name;

  public int id;

  public Board(String name, int id) {
    this.name = name;
    this.tasks = new ArrayList<>(); // Use ArrayList for dynamic size
    this.lastAssignedId = 0;
    this.ids = new ArrayList<>(); // Initialize the list
    this.id = id;
    ids.add(lastAssignedId); // Add the initial ID
}


    public int generateNewTaskId() {
    int newId = ++lastAssignedId;
    ids.add(newId);
    return newId; // Increment the last assigned ID
  }

  public List <Integer> getIdsList(){
    return this.ids;
  }

  public int getLastAssignedId(){
    return this.lastAssignedId;
  }

  public void addTaskToList(Task task){
    tasks.add(task);
  }

  public String getName(){
    return this.name;
  }

  public List <Task> getTasks(){
    return this.tasks;
  }

  public int getId(){
    return this.id;
  }



}
