package mina.study.domain.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mina.study.domain.post.Post;
import mina.study.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Lob
    private String content;

    public Comment(User user, Post post) {
        this.user = user;
        this.post = post;
        post.addComment(this);
    }
}
