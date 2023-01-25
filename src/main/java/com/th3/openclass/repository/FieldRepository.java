package com.th3.openclass.repository;

import com.th3.openclass.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FieldRepository extends JpaRepository<Field, String> {
}
