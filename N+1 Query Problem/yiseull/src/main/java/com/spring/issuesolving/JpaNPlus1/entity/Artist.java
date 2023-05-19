package com.spring.issuesolving.JpaNPlus1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
//    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)  // 해결방안 3. FetchMode.SUBSELECT
//    @BatchSize(size=5)  // 해결방안 4. BatchSize
    private List<Song> songs;

    public Artist(String name) {
        this.name = name;
    }

}
