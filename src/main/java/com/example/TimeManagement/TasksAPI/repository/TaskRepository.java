package com.example.TimeManagement.TasksAPI.repository;


import com.example.TimeManagement.TasksAPI.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
