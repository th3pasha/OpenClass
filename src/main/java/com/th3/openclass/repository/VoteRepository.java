package com.th3.openclass.repository;

import com.th3.openclass.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends JpaRepository<Vote, String> {
}
