package com.example.feedofcards;

import com.example.feedofcards.model.DailyCard;
import com.example.feedofcards.model.StatusCard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CardsController {

    private final CardsService cardsService;

    @GetMapping("/dailyCard")
    public ResponseEntity<DailyCard> getDailyCard(@RequestParam("userId") String userId) {
        DailyCard result = cardsService.getDailyCard(getRequestedUserId(userId));
        if (isNull(result)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }


    @GetMapping("/dailyCardConditional")
    public ResponseEntity<DailyCard> getDailyCardConditional(@RequestParam("userId") String userId) {
        DailyCard result = cardsService.getDailyCard(getRequestedUserId(userId));
        if (isNull(result)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/statusCard")
    public ResponseEntity<List<StatusCard>> getStatusCard(@RequestParam("userId") String userId) {
        List<StatusCard> result = cardsService.getStatusCard(getRequestedUserId(userId));
        if (isNull(result) || result.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/statusCardConditional")
    public ResponseEntity<List<StatusCard>> getStatusCardConditional(@RequestParam("userId") String userId) {
        List<StatusCard> result = cardsService.getStatusCard(getRequestedUserId(userId));
        if (isNull(result) || result.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    private Long getRequestedUserId(String userId) {
        Long requestedUserId = null;
        try {
            requestedUserId = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            log.info("Request came without userId or userId parameter has wrong format.");
        }
        return requestedUserId;
    }

}
