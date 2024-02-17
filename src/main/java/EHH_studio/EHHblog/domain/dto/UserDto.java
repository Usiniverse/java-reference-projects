package EHH_studio.EHHblog.domain.dto;

import EHH_studio.EHHblog.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDto {
    private Long id;
    private String loginId; // 로그인할 때 사용되는 아이디
    private String password; // 비밀번호
    private String nickname; // 닉네임
}
