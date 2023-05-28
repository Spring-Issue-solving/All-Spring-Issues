package com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.BatchSize;

import java.util.List;
import java.util.Set;

@Getter
@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "band")
    private List<BandMember> bandMembers;
//    private Set<BandMember> bandMembers;  // Solution 1

//    @BatchSize(size = 1000)   // Solution 3
    @OneToMany(mappedBy = "band")
//    @OrderColumn(name = "POSITION")  // Solution 2
    private List<BandSong> bandSongs;
//    private Set<BandSong> bandSongs;  // Solution 1

}
