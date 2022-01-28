package com.example.feedofcards.repository;

import com.example.feedofcards.repository.entity.DailyCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DailyCardRepository extends JpaRepository<DailyCardEntity, Long> {

    Optional<DailyCardEntity> getFirstByDay(Integer day);

}
