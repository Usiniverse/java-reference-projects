package EHH_studio.EHHblog.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board; // 댓글이 달린 게시판

    public void update(String newBody) {
        this.body = newBody;
    }
}
