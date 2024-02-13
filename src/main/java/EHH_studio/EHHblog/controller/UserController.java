package EHH_studio.EHHblog.controller;

import EHH_studio.EHHblog.service.UserService;
import EHH_studio.EHHblog.domain.User;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public User create(@RequestBody User user) {
        user.setName(user.getName());
        user.setAge(user.getAge());

        userService.save(user);
        return user;
    }

    @PutMapping("")
    public User update(
            @RequestParam Long id,
            @RequestBody User user
    ) {
        String name = user.getName();
        int age = user.getAge();

        userService.update(id, name, age);
        return userService.findById(id);
    }


    @DeleteMapping("")
    public String delete(@RequestParam Long id) {
        userService.remove(id);
        return id + "번 회원 삭제 완료!";
    }

    @GetMapping("")
    public String read(@RequestParam @Nullable Long id, String name) {
        if (id != null) {
            return userService.findById(id).toString();
        } else {
            return userService.findByName(name).toString();
        }
    }

    @GetMapping("/all")
    public String readAll() {
        return userService.findAll().toString();
    }
}
