package com.example.TaskManager2.repository;


import com.example.TaskManager2.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {
}
