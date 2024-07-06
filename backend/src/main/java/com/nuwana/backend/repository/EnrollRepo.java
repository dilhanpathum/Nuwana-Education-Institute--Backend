package com.nuwana.backend.repository;

import com.nuwana.backend.entity.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepo extends JpaRepository<Enroll , Long> {
}
