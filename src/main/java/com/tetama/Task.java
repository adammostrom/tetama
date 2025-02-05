package com.example.tetama;

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

  private Task(TaskBuilder builder) {
    this.boardId = builder.boardId;
    this.id = builder.id;
    this.description = builder.description;
    this.label = builder.label;
    this.date = builder.date;
    this.priority = builder.priority;
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

  public static class TaskBuilder {

    /** Required parameter. assigned by handler */
    private final int boardId;

    /** Required parameter. assigned by handler */
    private final int id;

    /** Required parameter. */
    private final String description;

    /** Required parameter. */
    private final String label;

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

    public TaskBuilder setDate(LocalDate date) {
      this.date = date;
      return this;
    }

    public Task build() {
      return new Task(this);
    }
  }
}
