package com.spring.issuesolving;

import com.spring.issuesolving.JpaNPlus1.Artist;
import com.spring.issuesolving.JpaNPlus1.ArtistRepository;
import com.spring.issuesolving.JpaNPlus1.Song;
import com.spring.issuesolving.JpaNPlus1.SongRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JpaNPlus1Test {

    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private SongRepository songRepository;

    @BeforeEach
    public void setup() {

        // given
        Artist artist1 = new Artist("뉴진스");
        artistRepository.save(artist1);

        Artist artist2 = new Artist("Maroon 5");
        artistRepository.save(artist2);

        Song song1 = Song.builder().title("Hype boy").artist(artist1).build();
        songRepository.save(song1);

        Song song2 = Song.builder().title("Attention").artist(artist1).build();
        songRepository.save(song2);

        Song song3 = Song.builder().title("Memories").artist(artist2).build();
        songRepository.save(song3);
    }

    @DisplayName("CASE 1. FetchType.EAGER")
    @Test
    @Transactional
    void occurJpaNPlus1_EAGER() {

        // when - JPA N+1 문제 발생: 조회는 1번 했지만 조회 쿼리는 3번 실행
        List<Artist> artists = artistRepository.findAll();

        // then
        assertThat(artists.size()).isEqualTo(2);
    }

    @DisplayName("CASE 2. FetchType.LAZY")
    @Test
    @Transactional
    void occurJpaNPlus1_LAZY() {
         // when
        List<Artist> artists = artistRepository.findAll();
        for (Artist artist : artists) {
            System.out.println("================ N+1 problem occur ================");
            System.out.println(artist.getName());
            artist.getSongs().forEach(song -> System.out.println(song.getTitle()));
        }

        // then
        assertThat(artists.size()).isEqualTo(2);
    }

    @DisplayName("해결방안 1. Fetch join")
    @Test
    @Transactional
    void solveJpaNPlus1_FetchJoin() {

        // when
        List<Artist> artists = artistRepository.findAllJoinFetch();

        // then
        assertThat(artists.size()).isEqualTo(2);
    }

    @DisplayName("해결방안 2. EntityGraph")
    @Test
    @Transactional
    void solveJpaNPlus1_EntityGraph() {

        // when
        List<Artist> artists = artistRepository.findAllEntityGraph();

        // then
        assertThat(artists.size()).isEqualTo(2);
    }

    @DisplayName("해결방안 3. FetchMode.SUBSELECT")
    @Test
    @Transactional
    void solveJpaNPlus1_SUBSELECT() {

        // when
        List<Artist> artists = artistRepository.findAll();

        // then
        assertThat(artists.size()).isEqualTo(2);
    }
}
