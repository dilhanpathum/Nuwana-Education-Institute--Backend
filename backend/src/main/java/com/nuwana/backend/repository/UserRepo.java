package com.nuwana.backend.repository;

import com.nuwana.backend.entity.Enroll;
import com.nuwana.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User findUserByemail(String email);
    User findUserById(int id);
    @Query("SELECT u FROM User u WHERE u.role = 'student'")
    List<User> findAllStudents();
}
