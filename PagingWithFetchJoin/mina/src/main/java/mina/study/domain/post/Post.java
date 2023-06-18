package mina.study.domain.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mina.study.domain.comment.Comment;
import mina.study.domain.user.User;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    @Lob
    private String content;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @BatchSize(size = 100)
    private List<Comment> comments = new ArrayList<>();

    public Post(User user) {
        this.user = user;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
