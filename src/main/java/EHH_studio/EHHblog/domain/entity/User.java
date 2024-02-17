package EHH_studio.EHHblog.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId; // 로그인할 때 사용되는 아이디
    private String password; // 비밀번호
    private String nickname; // 닉네임
    private LocalDateTime createdAt; // 가입 시간
//    private Integer receivedLikeCnt; // 유저가 받은 좋아요 수

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Board> boards; // 작성글

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Like> likes; // 유저가 누른 좋아요

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Comment> comments; // 댓글

    //====핵심 비즈니스 로직은 Entity 포함===//
    public void edit(String newPassword, String newNickname) {
        this.password = newPassword;
        this.nickname = newNickname;
    }
}
