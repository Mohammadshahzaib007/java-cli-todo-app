package org.example.tasktracker;

import java.util.ArrayList;
//import java.util.List;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String title, String description) {
        int id =  tasks.size() + 1;
        Task task = new Task(id, title, description, Status.IN_PROGRESS);
        tasks.add(task);
    }

    public void listTask() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println(i+1 + ". " + task.title);
            System.out.println("   Description: " + task.description);
            String status = task.status == Status.DONE ? "✅" : "In progress ⚒️";
            System.out.println("   Status: " + status);
        }
    }

    public void updateTaskStatus(int id, Status newStatus) {
        Task task = null;

        for (Task t: tasks) {
            if(t.getId() == id) {
                task = t;
                break;
            }
        }

        task.setStatus(newStatus);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.id == id);
    }
}
