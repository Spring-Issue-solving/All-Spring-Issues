package com.spring.issuesolving.JpaNPlus1.repository;

import com.spring.issuesolving.JpaNPlus1.entity.Artist;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query("select a from Artist a join fetch a.songs")
    List<Artist> findAllJoinFetch();

    @EntityGraph(attributePaths = "songs")
    @Query("select a from Artist a")
    List<Artist> findAllEntityGraph();
}
