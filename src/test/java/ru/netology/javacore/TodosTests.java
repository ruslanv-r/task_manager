package ru.netology.javacore;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TodosTests {

    @Test
    public void testAlphaOrder() {

        Todos todos = new Todos();
        todos.addTask("Поход");
        todos.addTask("автоматизировать");
        todos.addTask("спать");

        Todos resultTodos = new Todos();
        resultTodos.addTask("автоматизировать");
        resultTodos.addTask("Поход");
        resultTodos.addTask("спать");

        String val1 = todos.getAllTasks();
        System.out.println(val1);

        StringJoiner sj = new StringJoiner(", ");
        for (String str : resultTodos.getTask()) {
            sj.add(str);
        }
        String val2 = sj.toString();

        Assertions.assertEquals(val2, val1);

    }

    @Test
    public void testAddTasks() {
        Todos todos = new Todos();
        todos.addTask("Рыбалка");
        StringJoiner sj = new StringJoiner(" ");
        for (String str : todos.getTask()) {
            sj.add(str);
        }
        String val1 = sj.toString();
        String val2 = "Рыбалка";


        Assertions.assertEquals(val2, val1);

    }

}
