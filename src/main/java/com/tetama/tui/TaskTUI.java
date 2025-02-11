package com.tetama.tui;


import com.tetama.Board;
import com.tetama.Task;
import com.tetama.managers.TaskManager;

import java.util.List;
import java.util.Scanner;

public class TaskTUI {

    private TaskManager manager;

    private Task.TaskBuilder builder;
    private Scanner scanner;

    public TaskTUI() {
        this.manager = new TaskManager();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nSelect a board:");
            List<Board> boards = manager.getBoards();
            for (int i = 0; i < boards.size(); i++) {
                System.out.println((i + 1) + ". " + boards.get(i).getName());
            }
            System.out.print("\nEnter board number (or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) break;
            int boardIndex = Integer.parseInt(input) - 1;
            if (boardIndex < 0 || boardIndex >= boards.size()) continue;

            Board selectedBoard = boards.get(boardIndex);
            handleBoard(selectedBoard);
        }
    }

    private void handleBoard(Board board) {
        while (true) {
            TaskUI.displayTasks(board.getTasks());
            System.out.print("\nEnter option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "a":
                    addTask(board);
                    break;
                case "d":
                    deleteTask(board);
                    break;
                case "x":
                    markFinished(board);
                    break;
                case "w":
                    markStarted(board);
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    private void addTask(Board board) {
        System.out.print("Task description: ");
        String desc = scanner.nextLine();
        System.out.print("Start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
        System.out.print("End date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();
        System.out.print("Todo date (YYYY-MM-DD): ");
        String todoDate = scanner.nextLine();
        System.out.print("Label: ");
        String label = scanner.nextLine();
        System.out.print("Priority (low/medium/high): ");
        String priority = scanner.nextLine();

        int newId = board.getTasks().size() + 1;
        builder = new Task.TaskBuilder(newId, id, desc, label);
        builder.setStartedDate(startDate);
        Task newTask = builder(newId, desc, priority, startDate, endDate, todoDate, label);
        board.addTask(newTask);
        manager.saveBoards();
    }

    private void deleteTask(Board board) {
        System.out.print("Enter task ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        board.removeTask(id);
        manager.saveBoards();
    }

    private void markFinished(Board board) {
        System.out.print("Enter task ID to mark as finished: ");
        int id = Integer.parseInt(scanner.nextLine());
        Task task = board.getTaskById(id);
        if (task != null) {
            task.setFinished(true);
            manager.saveBoards();
        }
    }

    private void markStarted(Board board) {
        System.out.print("Enter task ID to mark as started: ");
        int id = Integer.parseInt(scanner.nextLine());
        Task task = board.getTaskById(id);
        if (task != null) {
            task.setStarted(true);
            manager.saveBoards();
        }
    }

    public static void main(String[] args) {
        TaskTUI app = new TaskTUI();
        app.start();
    }
}
