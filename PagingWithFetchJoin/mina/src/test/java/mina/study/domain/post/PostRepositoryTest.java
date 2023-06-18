package mina.study.domain.post;

import mina.study.domain.comment.Comment;
import mina.study.domain.user.User;
import mina.study.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager em;

    @BeforeEach
    public void setUp(){
        List<Post> posts = new ArrayList<>();
        User user = new User("mina");
        userRepository.save(user);

        for(int i=0;i<10;i++){
            Post post = new Post(user);
            posts.add(post);
        }
        postRepository.saveAll(posts);
    }

    @Test
    @Transactional
    void pagingTest() {
        System.out.println("--------------start-----------------");
        List<Post> posts = postRepository.findAll(PageRequest.of(0, 5)).getContent();
        System.out.println("--------------getComments-----------------");
        for(Post post : posts) System.out.println(post.getComments());
        System.out.println("--------------end-----------------");
    }

    @Test
    @Transactional
    void fetchJoinTest() {
        System.out.println("--------------start-----------------");

//        List<Post> posts = postRepository.findWithPagination(PageRequest.of(0, 5)).getContent();


        List<Post> posts = em
                .createQuery("select p from Post p join fetch p.comments", Post.class)
                .setFirstResult(0)
                .setMaxResults(5)
                .getResultList();

        System.out.println("--------------end-----------------");
    }

    @Test
    @Transactional
    void batchSizeTest() {
        System.out.println("--------------start-----------------");

        List<Post> posts = em.createQuery("select p from Post p", Post.class)
                .setFirstResult(0)
                .setMaxResults(5)
                .getResultList();

//        List<Post> posts = postRepository.findAll(PageRequest.of(0, 5)).getContent();
        
        System.out.println("--------------end-----------------");
    }


}