package com.spring.issuesolving.JpaNPlus1.repository;

import com.spring.issuesolving.JpaNPlus1.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
