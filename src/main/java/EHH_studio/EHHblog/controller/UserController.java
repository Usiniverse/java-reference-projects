package EHH_studio.EHHblog.controller;

import EHH_studio.EHHblog.domain.dto.UserDto;
import EHH_studio.EHHblog.domain.dto.UserJoinRequest;
import EHH_studio.EHHblog.domain.entity.User;
import EHH_studio.EHHblog.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // create
    @PostMapping("")
    public String save(@RequestBody @Valid UserJoinRequest dto) {
        userService.save(dto);
        return "회원가입 성공";
    }

    // read
    @GetMapping("/userId")
    public User findById(@RequestBody @Valid Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/nickname")
    public User findByNickname(@RequestBody @Valid String nickname) {
        return userService.findByNickname(nickname);
    }

    // update
    @PutMapping("")
    public String update(@RequestBody @Valid UserDto dto) {
        userService.update(dto);
        return "회원정보 수정";
    }

    // delete
    @DeleteMapping("")
    public String delete(@RequestBody @Valid Long userId) {
        userService.delete(userId);
        return "회원탈퇴";
    }
}
