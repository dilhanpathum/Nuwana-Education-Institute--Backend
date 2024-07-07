package com.nuwana.backend.repository;

import com.nuwana.backend.entity.Enroll;
import com.nuwana.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollRepo extends JpaRepository<Enroll , Long> {
    Enroll findUserByemail(String email);

    @Query("SELECT e FROM Enroll e WHERE e.status = 'not'")
    List<Enroll> findAllPendingEnrolls();
    @Query("SELECT e FROM Enroll e WHERE e.status = 'accept'")
    List<Enroll> findAllAcceptedEnrolls();

}
