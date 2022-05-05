package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Todos {
    //...
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {

        tasks.add(task);

    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {

        Stream<String> stream = tasks.stream();
        List<String> resultList = stream
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        StringJoiner sj = new StringJoiner(", ");
        for (String str: resultList){
            sj.add(str);
        }
        return sj.toString();


    }

    public List<String> getTask() {
        return tasks;
    }

    public void setTask(List<String> task) {
        this.tasks = task;
    }

    @Override
    public String toString() {
        return tasks.toString();
    }
}
