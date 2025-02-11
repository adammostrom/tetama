package com.tetama.tui;


import com.tetama.Task;

import java.util.List;


public class TaskUI {

    public static void displayTasks(List<Task> tasks) {
        System.out.println("\nTASK LIST:");
        System.out.printf("%-4s %-40s %-12s %-12s %-12s %-10s %-8s %-3s\n",
                "", "Description", "Start Date", "End Date", "Todo Date", "Label", "Priority", "ID");
        System.out.println("------------------------------------------------------------------------------------------");

        for (Task task : tasks) {
            String status = task.isFinished() ? "[#]" : (task.isStarted() ? "[/]" : "[ ]");
            System.out.printf("%-4s %-40s %-12s %-12s %-12s %-10s %-8s %-3d\n",
                    status, task.getDescription(), task.getStartDate(), task.getEndDate(),
                    task.getTodoDate(), task.getLabel(), task.getPriority(), task.getId());
        }
        System.out.println("\nOptions: (a) Add | (d) Delete | (x) Finish | (w) Work on task | (q) Quit");
    }
}
