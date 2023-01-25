package com.th3.openclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.th3.openclass.model.Field;


@Repository
public interface FieldRepository extends JpaRepository<Field, Long>
{

}
