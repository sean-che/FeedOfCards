package com.example.feedofcards.repository;

import com.example.feedofcards.repository.entity.DailyCardEntity;
import com.example.feedofcards.repository.entity.DailyCardView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DailyCardViewRepository extends JpaRepository<DailyCardView, Long> {

    Optional<DailyCardView> findByDailyCardAndUserId(DailyCardEntity dailyCardEntity, Long userId);

}
