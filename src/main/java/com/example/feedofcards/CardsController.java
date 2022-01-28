package com.example.feedofcards;

import com.example.feedofcards.model.DailyCard;
import com.example.feedofcards.model.StatusCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/dailyCard")
    public ResponseEntity<DailyCard> getDailyCard() {
        return ResponseEntity.ok(new DailyCard("Daily Quote", "quote1", "author1"));
    }

    @GetMapping("/statusCard")
    public ResponseEntity<StatusCard> getStatusCard() {
        return ResponseEntity.ok(new StatusCard(
                "Important Security Update",
                "https://tinyurl.com/y5mdph2g",
                "For your security, we support 2 factor authentication, and would recommend that you turn it on.",
                "Got it, thanks"));
    }

}
