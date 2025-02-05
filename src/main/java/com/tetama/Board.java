package com.tetama;
import java.util.List;
import java.util.ArrayList;

public class Board {
  public List <Task> tasks;
  public String name;
  public int id;

  public Board(String name, int id) {
    this.name = name;
    this.tasks = new ArrayList<>();
  }
  public void addTaskToList(Task task){
    tasks.add(task);
  }

  public void removeTask(int id){
    tasks.removeIf(t -> t.getId() == id);
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
