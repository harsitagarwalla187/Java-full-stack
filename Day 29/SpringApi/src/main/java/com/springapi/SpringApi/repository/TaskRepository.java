package com.springapi.SpringApi.repository;

import com.springapi.SpringApi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public Task findByTitle(String title);
}
