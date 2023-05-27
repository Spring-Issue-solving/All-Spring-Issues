package com.spring.issuesolving.jpa;


import com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity.Band;
import com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity.BandMember;
import com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.entity.BandSong;
import com.spring.issuesolving.jpa.cannot_multiple_fetchjoin.repository.BandRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
public class MultipleFetchJoinTest {

    @Autowired
    private BandRepository bandRepository;

    @Autowired
    private EntityManager entityManager;

    @DisplayName("MultipleBagFetchException 예외 발생")
    @Test
    public void MultipleBagFetchExceptionTest() {
        assertThatThrownBy(() -> bandRepository.findAllWithFetchJoin())
                .isInstanceOf(InvalidDataAccessApiUsageException.class)
                .hasMessageContaining("MultipleBagFetchException");
    }

    @Nested
    @DisplayName("솔루션")
    class Solution {

        @DisplayName("1. Set 사용")
        @Test
        public void UseSet() {
            // when
            List<Band> bandList = bandRepository.findAllWithFetchJoin();
            // then
            assertThat(bandList.size()).isEqualTo(2);
        }

        @DisplayName("2. List 사용")
        @Test
        public void UseList() {
            // when
            List<Band> bandList = bandRepository.findAllWithFetchJoin();
            // then
            assertThat(bandList.size()).isEqualTo(2);
        }

        @DisplayName("3. BatchSize 사용")
        @Test
        public void UseBatchSize() {
            // when
            List<Band> bandList = bandRepository.findAllWithFetchJoinAndBatchSize();
            for (Band band : bandList) {
                System.out.println("band.getName() = " + band.getName());
                for (BandMember member : band.getBandMembers()) {
                    System.out.println("member.getName() = " + member.getName());
                }
                for (BandSong song : band.getBandSongs()) {
                    System.out.println("song.getTitle() = " + song.getTitle());
                }
            }
            // then
            assertThat(bandList.size()).isEqualTo(2);
        }

        @DisplayName("4. 다중 쿼리 사용")
        @Test
        public void UseMultipleQuery() {
            // when
            List<Band> bands = bandRepository.findAllWithBandMembers();
            bands = bandRepository.findArtistsWithSongs(bands);

            // then
            assertThat(bands.size()).isEqualTo(2);
        }
    }
}
