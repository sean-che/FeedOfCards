package com.example.feedofcards.repository;

import com.example.feedofcards.repository.entity.StatusCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusCardRepository extends JpaRepository<StatusCardEntity, Long> {
}
