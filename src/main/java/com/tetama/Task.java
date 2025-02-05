package com.tetama;

import jdk.vm.ci.meta.Local;

import java.time.LocalDate;

public class Task {

  /** Required parameter. assigned by handler */
  private final int boardId;

  /** Required parameter. assigned by handler */
  private final int id;

  /** Required parameter. */
  private final String description;

  /** Required parameter. */
  private final String label;

  /** Optional parameter. */
  private final Priority priority;

  /** optional parameter. */
  private final LocalDate date;

  private final LocalDate startedDate;

  private final LocalDate endedDate;

  private Task(TaskBuilder builder) {
    this.boardId = builder.boardId;
    this.id = builder.id;
    this.description = builder.description;
    this.label = builder.label;
    this.date = builder.date;
    this.priority = builder.priority;
    this.startedDate = builder.startedDate;
    this.endedDate = builder.endedDate;
  }

  public int getBoardId() {
    return this.boardId;
  }

  public int getId() {
    return this.id;
  }

  public Priority getPrio() {
    return this.priority;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public String getLabel() {
    return this.label;
  }

  public String getDescription() {
    return this.description;
  }

  public LocalDate getStartedDate(){return this.startedDate; }

  public LocalDate getEndedDate(){return this.endedDate; }


  public static class TaskBuilder {

    /** Required parameter. assigned by handler */
    private final int boardId;

    /** Required parameter. assigned by handler */
    private final int id;

    /** Required parameter. */
    private final String description;

    /** Required parameter. */
    private final String label;
    private LocalDate startedDate;

    private LocalDate endedDate;

    /** Optional parameter. */
    private Priority priority;

    /** optional parameter. */
    private LocalDate date;

    public TaskBuilder(int boardId, int id, String description, String label) {
      this.boardId = boardId;
      this.id = id;
      this.description = description;
      this.label = label;
    }

    public TaskBuilder setPriority(Priority priority) {
      this.priority = priority;
      return this;
    }

    public TaskBuilder setTodoDate(LocalDate date) {
      this.date = date;
      return this;
    }

    public TaskBuilder setStartedDate(LocalDate startedDate){
      this.startedDate = startedDate;
      return this;
    }

    public TaskBuilder setEndedDate(LocalDate endedDate){
      this.endedDate = endedDate;
      return this;
    }

    public Task build() {
      return new Task(this);
    }
  }
}
