package com.springapi.SpringApi.controller;

import com.springapi.SpringApi.model.Task;
import com.springapi.SpringApi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
//        return taskService.getAllTasks();

        List<Task> tasks = taskService.getAllTasks();
//        List<Task> tasks = Arrays.asList();

        if(tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {

        Optional<Task> task = taskService.getTaskById(id);

        if(task.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Fetch-By", "TaskController");
            return ResponseEntity.ok().headers(headers).body(task.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/task/{title}")
    public Task getTaskByTitle(@PathVariable("title") String title) {
        return taskService.getTaskByTitle(title);
    }

    @PostMapping("/")
    public Task addTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
//        Task task1 = taskService.getTaskById(id).get();
        task.setId(id);
        return taskService.saveTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }
}
