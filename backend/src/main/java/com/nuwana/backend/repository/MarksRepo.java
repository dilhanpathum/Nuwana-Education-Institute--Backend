package com.nuwana.backend.repository;

import com.nuwana.backend.entity.Marks;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MarksRepo extends JpaRepository<Marks, Long> {
    @Query("SELECT m FROM Marks m WHERE m.month = 'October' ORDER BY m.marks DESC")
    List<Marks> findTop5ByMarks(Pageable pageable);
}
