package EHH_studio.EHHblog.domain.dto;

import EHH_studio.EHHblog.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;


//===회원가입 시 사용될 DTO===
@Getter
@NoArgsConstructor
@Builder
public class UserJoinRequest {
    private String loginId;
    private String password;
    private String nickname;
    private LocalDateTime createdAt;

    public UserJoinRequest(String loginId, String password, String nickname, LocalDateTime createdAt) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.createdAt = createdAt;
    }

    public User toEntity() {
        return User.builder()
                .loginId(loginId)
                .password(password) // encodedPassword로 변경해야함.
                .nickname(nickname)
                .createdAt(createdAt)
                .build();
    }
}
