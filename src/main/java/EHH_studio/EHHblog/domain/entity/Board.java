package EHH_studio.EHHblog.domain.entity;

import EHH_studio.EHHblog.domain.enum_class.BoardCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 제목
    private String body; // 본문

    @Enumerated(EnumType.STRING)
    private BoardCategory category; // 카테고리

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 작성자

    @OneToMany(mappedBy = "board", orphanRemoval = true)
    private List<Comment> comments;
//    private Integer commentCnt;
}
