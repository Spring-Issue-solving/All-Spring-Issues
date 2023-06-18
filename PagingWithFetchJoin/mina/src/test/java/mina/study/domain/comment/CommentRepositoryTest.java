package mina.study.domain.comment;

import mina.study.domain.post.Post;
import mina.study.domain.post.PostRepository;
import mina.study.domain.user.User;
import mina.study.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
//@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Autowired EntityManager em;

    @BeforeEach
    public void setUp(){

        User user = new User("mina");
        userRepository.save(user);
        Post post = new Post(user);
        postRepository.save(post);

        List<Comment> comments = new ArrayList<>();

        for(int i=0;i<10;i++){
            Comment comment = new Comment();
            comments.add(comment);
        }
        commentRepository.saveAll(comments);
    }

    @Test
    @Transactional
    void commentTest() {
        System.out.println("--------------start-----------------");
        List<Comment> comments = em
                .createQuery("select c from Comment c join fetch c.post", Comment.class)
                .setFirstResult(0)
                .setMaxResults(5)
                .getResultList();

//        List<Comment> comments = commentRepository.findAll(PageRequest.of(0, 5)).getContent();
        System.out.println("--------------end-----------------");
    }

}