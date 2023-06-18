package mina.study.domain.post;

import mina.study.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    @Query(value = "select distinct p from Post p join fetch p.comments", nativeQuery = true)
    Page<Post> findWithPagination(Pageable pageable);

}
