package com.example.feedofcards;

import com.example.feedofcards.model.DailyCard;
import com.example.feedofcards.model.StatusCard;
import com.example.feedofcards.repository.DailyCardRepository;
import com.example.feedofcards.repository.StatusCardRepository;
import com.example.feedofcards.repository.entity.DailyCardEntity;
import com.example.feedofcards.repository.entity.StatusCardEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardsService {

    private final DailyCardRepository dailyCardRepository;
    private final StatusCardRepository statusCardRepository;

    public DailyCard getDailyCard() {
        DailyCardEntity dailyCardEntity = dailyCardRepository.getById(1L);
        return new DailyCard(dailyCardEntity.getTitle(), dailyCardEntity.getMessage(), dailyCardEntity.getAuthor());
    }

    public StatusCard getStatusCard() {
        StatusCardEntity statusCardEntity = statusCardRepository.getById(1L);
        return new StatusCard(statusCardEntity.getTitle(), statusCardEntity.getIcon(), statusCardEntity.getMessage(), statusCardEntity.getButton());
    }

}
