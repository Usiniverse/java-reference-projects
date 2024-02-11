package EHH_studio.EHHblog.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(columnDefinition = "TEXT")
    private String content;
}
