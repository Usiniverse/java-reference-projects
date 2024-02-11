package EHH_studio.EHHblog.service;

import EHH_studio.EHHblog.domain.User;
import EHH_studio.EHHblog.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 유저 등록
    public Long save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    // 유저 수정
    public Long update(Long id, String newName, int newAge) {
        User updateUser = userRepository.findById(id);
        updateUser.setName(newName);
        updateUser.setAge(newAge);

        return updateUser.getId();
    }

    // 유저 삭제
    public void remove(Long id) {
        userRepository.remove(id);
    }

    // id로 유저 검색
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    // name으로 유저 검색
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    // 유저 전체 검색
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
