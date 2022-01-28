package com.example.feedofcards.repository;

import com.example.feedofcards.repository.entity.StatusCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusCardRepository extends JpaRepository<StatusCardEntity, Long> {

    @Query("select sc from StatusCardEntity sc where not exists (select 1 from sc.statusCardViews cv where cv.userId = :userId)")
    List<StatusCardEntity> findAllWithoutViews(@Param("userId") Long userId);

}
