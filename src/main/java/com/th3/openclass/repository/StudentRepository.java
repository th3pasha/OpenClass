package com.th3.openclass.repository;

import com.th3.openclass.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, String>
{
    Optional<Student> findByEmail(String studentEmail);
}
