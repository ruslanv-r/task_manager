package ru.netology.javacore;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Todos todos = new Todos();
        TodoServer server = new TodoServer(8989, todos);
        server.start();

//        todos.addTask("2Пойти в кино");
//        todos.addTask("4Пойти в магазин");
//        todos.addTask("3Пойти в банк");
//        todos.addTask("5Проверить теплицу");
//        todos.addTask("1Аргументы");

//        todos.addTask("Поход");
//        todos.addTask("Автоматизировать");
//        todos.addTask("спать");

        System.out.println(todos.getAllTasks());
    }
}
