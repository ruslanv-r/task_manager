package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class TodoServer {
    public int port;
    public Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                System.out.println("Starting server at " + port + "...");
                try (
                        Socket connection = serverSocket.accept();
                        PrintWriter out = new PrintWriter(connection.getOutputStream(), true); //исх
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); //вх
                ) {
                    System.out.println("Port - " + connection.getPort());
                    String inValue = in.readLine();
                    System.out.println(inValue);


                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    Map map = gson.fromJson(inValue, Map.class);
                    System.out.println(map);
                    if (map.containsKey("type")) {
                        String str = (String) map.get("type");
                        if (str.equals("ADD")) {
                            todos.addTask((String) map.get("task"));
                        }

                    }
                    System.out.println(todos.getAllTasks());
                    out.println(todos.getAllTasks());
                    //serverSocket.close();

                }

            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
