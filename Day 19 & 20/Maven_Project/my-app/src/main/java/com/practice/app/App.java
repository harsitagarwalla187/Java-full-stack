package com.practice.app;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello Harsit!");
        Task t = new Task(2121312, "Harsit Agarwalla");
        Gson gson = new Gson();
        String json = gson.toJson(t);
        System.out.println(json);
    }
}

//mvn archetype:generate -DgroupId=com.practice.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
//mvn clean install
//java -cp target/my-app-1.0-SNAPSHOT.jar com.practice.app.App

class Task {
    int rollno;
    String name;
    Task(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
}