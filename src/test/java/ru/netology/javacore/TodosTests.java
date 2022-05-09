package ru.netology.javacore;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TodosTests {
    Todos todos;
    public static int i = 1;

    @BeforeEach
    public void createTodos() {

        System.out.println("Тест " + i + " запущен");
        i++;
        todos = new Todos();

    }

    @Test
    public void testAlphaOrder() {
//        Todos todos = new Todos();
        todos.addTask("2Поход");
        todos.addTask("1автоматизировать");
        todos.addTask("3спать");

        String val1 = todos.getAllTasks();
        System.out.println(val1);

        String val2 = "1автоматизировать, 2Поход, 3спать";

        Assertions.assertEquals(val2, val1);

    }

    @Test
    public void testAddTasks() {
//        Todos todos = new Todos();
        todos.addTask("Рыбалка");
        StringJoiner sj = new StringJoiner(" ");
        for (String str : todos.getTask()) {
            sj.add(str);
        }
        String val1 = sj.toString();
        String val2 = "Рыбалка";

        assertEquals(val2, val1);

    }

    @Test
    public void testRemoveTask() {
        Todos todos = new Todos();
        todos.addTask("Рыбалка");
        todos.removeTask("Рыбалка");

        assertTrue(todos.getAllTasks().isEmpty());
    }

    @AfterEach
    void finalTest() {
        System.out.println("Тест пройден");
    }
}

