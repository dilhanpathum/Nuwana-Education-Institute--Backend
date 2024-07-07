package com.nuwana.backend.repository;

import com.nuwana.backend.entity.Enroll;
import com.nuwana.backend.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
