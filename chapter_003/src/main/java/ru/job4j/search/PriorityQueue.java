package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.addFirst(task);
        } else {
            for (Task oldTask : tasks) {
                if (task.getPriority() <= oldTask.getPriority()) {
                    tasks.add(tasks.indexOf(oldTask), task);
                    break;
                } else if (!tasks.iterator().hasNext()) {
                    tasks.add(task);
                    break;
                }
            }
        }
    }
    public Task take() {
        return this.tasks.poll();
    }
}

