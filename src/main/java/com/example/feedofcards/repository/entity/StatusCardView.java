package com.example.feedofcards.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "daily_card_view")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusCardView implements Serializable {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status_card_id")
    private StatusCardEntity statusCard;

    @Column(nullable = false)
    private Long userId;

    @Builder.Default
    private LocalDateTime createdTimestamp = LocalDateTime.now();

}
