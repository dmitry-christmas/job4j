package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    int counter = 0;
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        for (int i = 0; i <= tasks.size(); i++) {
            if (counter <= i || task.getPriority() < tasks.get(i).getPriority()) {
                tasks.add(i, task);
                counter++;
                break;
            }
        }
    }
    public Task take() {
        return this.tasks.poll();
    }
}

