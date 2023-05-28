package com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.repository;

import com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

    @Query("SELECT b FROM Band b JOIN FETCH b.bandMembers JOIN FETCH b.bandSongs")
    List<Band> findAllWithFetchJoin();

    @Query("SELECT b FROM Band b JOIN FETCH b.bandMembers")
    List<Band> findAllWithFetchJoinAndBatchSize();

    @Query("SELECT DISTINCT b FROM Band b LEFT JOIN FETCH b.bandMembers")
    List<Band> findAllWithBandMembers();

    @Query("SELECT DISTINCT b FROM Band b LEFT JOIN FETCH b.bandSongs WHERE b IN :bands")
    List<Band> findArtistsWithSongs(@Param("bands") List<Band> bands);
}
