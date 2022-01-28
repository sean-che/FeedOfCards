package com.example.feedofcards;

import com.example.feedofcards.model.DailyCard;
import com.example.feedofcards.model.StatusCard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardsService {

    public DailyCard getDailyCard() {
        return new DailyCard("Daily Quote", "quote1", "author1");
    }

    public StatusCard getStatusCard() {
        return new StatusCard(
                "Important Security Update",
                "https://tinyurl.com/y5mdph2g",
                "For your security, we support 2 factor authentication, and would recommend that you turn it on.",
                "Got it, thanks");
    }

}
