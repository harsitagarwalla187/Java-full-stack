package com.example.StudentApi.repository;

import com.example.StudentApi.model.Attendance;
import com.example.StudentApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Employee findByEmployeeId(Long id);
}
