package com.example.feedofcards;

import com.example.feedofcards.model.DailyCard;
import com.example.feedofcards.model.StatusCard;
import com.example.feedofcards.repository.DailyCardRepository;
import com.example.feedofcards.repository.DailyCardViewRepository;
import com.example.feedofcards.repository.StatusCardRepository;
import com.example.feedofcards.repository.StatusCardViewRepository;
import com.example.feedofcards.repository.entity.DailyCardEntity;
import com.example.feedofcards.repository.entity.DailyCardView;
import com.example.feedofcards.repository.entity.StatusCardEntity;
import com.example.feedofcards.repository.entity.StatusCardView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardsService {

    private final DailyCardRepository dailyCardRepository;
    private final DailyCardViewRepository dailyCardViewRepository;
    private final StatusCardRepository statusCardRepository;
    private final StatusCardViewRepository statusCardViewRepository;

    public DailyCard getDailyCard(Long userId) {
        Optional<DailyCardEntity> optionalDailyCard = dailyCardRepository.getFirstByDay(1);
        if (optionalDailyCard.isEmpty()) {
            return null;
        }
        DailyCardEntity dailyCardEntity = optionalDailyCard.get();
        if (nonNull(userId)) {
            Optional<DailyCardView> dailyCardView = dailyCardViewRepository.findByDailyCardAndUserId(dailyCardEntity, userId);
            if (dailyCardView.isPresent()) {
                return null;
            } else {
                dailyCardViewRepository.save(DailyCardView.builder().dailyCard(dailyCardEntity).userId(userId).build());
            }
        }
        return new DailyCard(dailyCardEntity.getTitle(), dailyCardEntity.getMessage(), dailyCardEntity.getAuthor());
    }

    public List<StatusCard> getStatusCard(Long userId) {
        List<StatusCardEntity> statusCardEntities;
        if (isNull(userId)) {
            statusCardEntities = statusCardRepository.findAll();
        } else {
            statusCardEntities = statusCardRepository.findAllWithoutViews(userId);
        }
        if (isNull(statusCardEntities) || statusCardEntities.isEmpty()) {
            return null;
        }
        if (nonNull(userId)) {
            statusCardViewRepository.saveAll(statusCardEntities.stream()
                    .map(e -> StatusCardView.builder().statusCard(e).userId(userId).build()).toList());
        }
        return statusCardEntities.stream()
                .map(e -> new StatusCard(e.getTitle(), e.getIcon(), e.getMessage(), e.getButton())).toList();

    }

}
