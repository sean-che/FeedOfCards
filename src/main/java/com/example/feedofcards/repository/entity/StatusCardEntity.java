package com.example.feedofcards.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status_card")
@Data
public class StatusCardEntity implements Serializable {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128)
    private String title;
    @Column(length = 128)
    private String icon;
    @Column(length = 2000)
    private String message;
    @Column(length = 128)
    private String button;

}
