package org.example.tasktracker;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Remove Task");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // /n clean up
            switch (choice) {
                case 0:
                    System.out.println("You have chosen 0 options");
                    running = false;
                    break;
                case 1:
                    System.out.println("Enter task title: ");
                    String title = scanner.nextLine();

                    System.out.println("Enter task description: ");
                    String description = scanner.nextLine();

                    taskManager.addTask(title, description);
                    break;
                case 2:
                    taskManager.listTask();
                    break;
                case 3:
                    System.out.println("Enter task id to update task status");
                    int sId = scanner.nextInt();
                    scanner.nextLine(); // clean up

                    System.out.println("Enter D to mark task as Done or I for In progress");
                    String s = scanner.nextLine();

                    Status newStatus = s.equals("D") ? Status.DONE : Status.IN_PROGRESS;
                    taskManager.updateTaskStatus(sId, newStatus);
                    break;
                case 4:
                    System.out.println("Enter task id to remove");
                    int id = scanner.nextInt();
                    taskManager.removeTask(id);
                    System.out.println("Item Deleted ❌");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }

        scanner.close();

    }
}