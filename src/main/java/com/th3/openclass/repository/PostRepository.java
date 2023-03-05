package com.th3.openclass.repository;

import com.th3.openclass.model.Post;
import com.th3.openclass.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, String>
{
    Optional<Post> findPostByStudent(Student student);
}
