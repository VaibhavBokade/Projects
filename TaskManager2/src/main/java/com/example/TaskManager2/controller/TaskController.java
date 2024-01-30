package com.example.TaskManager2.controller;

import com.example.TaskManager2.Iservice.TaskServiceInterface;
import com.example.TaskManager2.entities.Task;
import com.example.TaskManager2.serviceImpl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taskManager")
public class TaskController {

    @Autowired
    private TaskServiceInterface taskServiceInterface;

    @PostMapping()
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskServiceInterface.addTask(task), HttpStatus.CREATED);
    }

}
