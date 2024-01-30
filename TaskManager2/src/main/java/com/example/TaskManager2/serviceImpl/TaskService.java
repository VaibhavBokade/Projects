package com.example.TaskManager2.serviceImpl;

import com.example.TaskManager2.Iservice.TaskServiceInterface;
import com.example.TaskManager2.entities.Task;
import com.example.TaskManager2.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private ITaskRepository taskRepository;
    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }
}
