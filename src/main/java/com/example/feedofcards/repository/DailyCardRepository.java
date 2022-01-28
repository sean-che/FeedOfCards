package com.example.feedofcards.repository;

import com.example.feedofcards.repository.entity.DailyCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyCardRepository extends JpaRepository<DailyCardEntity, Long> {
}
