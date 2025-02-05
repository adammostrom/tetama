package com.tetama.services;

import com.tetama.Priority;
import com.tetama.Task;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class TaskService {


  public TaskService() {
  }
  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");



  public Task createTask(List<String> args, int boardId, int taskId) {
    if (args.size() < 2 || args.size() > 4) {
      throw new IllegalArgumentException(
          "Task arguments need to be on the format: <description> <label> <priority (optional)> <date (optionla)>");
    }
    Task.TaskBuilder builder;

    String description = (args.get(0));
    String label = (args.get(1));
    Priority priority = null;
    LocalDate date = null;

    if (args.size() > 2) {
      priority = parsePriority(args.get(2));
    }
    if (args.size() > 3) {
      date = parseDate(args.get(3));
    }

    builder = new Task.TaskBuilder(boardId, taskId, description, label);

    if (date != null) {
      builder.setTodoDate(date);
    }
    if (priority != null) {
      builder.setPriority(priority);
    }
    Task task = builder.build();
    //databaseService.insertTask(task);
    return task;
  }

  /**
   *   NA(0),
   *   INSIGNIFICANT(1),
   *   LOW(2),
   *   MEDIUM(3),
   *   HIGH(4),
   *   URGENT(5);
   * @param priority
   * @return
   */
  private Priority parsePriority(String priority) {
      switch (priority) {
        case "na":
        case "0":
          return Priority.NA;
        case "insignificant":
        case "1":
          return Priority.INSIGNIFICANT;
        case "low":
        case "2":
          return Priority.LOW;
        case "medium":
        case "3":
          return Priority.MEDIUM;
        case "high":
        case "4":
          return Priority.HIGH;
        case "urgent":
        case "5":
          return Priority.URGENT;
        default: throw new IllegalArgumentException("No priorities matching the input value.");
      }
  }

  private LocalDate parseDate(String date) {
    if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
      throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd.");
    }
    try {
      return LocalDate.parse(date, DATE_FORMAT); // Return the valid date
    } catch (Error e) {
      throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd.", e);
    }
  }



}
