package com.example.feedofcards;

import com.example.feedofcards.model.DailyCard;
import com.example.feedofcards.model.StatusCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsService cardsService;

    @GetMapping("/dailyCard")
    public ResponseEntity<DailyCard> getDailyCard() {
        return ResponseEntity.ok(cardsService.getDailyCard());
    }

    @GetMapping("/statusCard")
    public ResponseEntity<StatusCard> getStatusCard() {
        return ResponseEntity.ok(cardsService.getStatusCard());
    }

}
