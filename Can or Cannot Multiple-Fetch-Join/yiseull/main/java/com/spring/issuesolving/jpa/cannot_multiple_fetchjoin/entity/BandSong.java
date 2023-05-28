package com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class BandSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_id")
    private Band band;

}
