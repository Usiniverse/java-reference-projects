package EHH_studio.EHHblog.service;

import EHH_studio.EHHblog.domain.dto.UserDto;
import EHH_studio.EHHblog.domain.dto.UserJoinRequest;
import EHH_studio.EHHblog.domain.entity.User;
import EHH_studio.EHHblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    // create
    public void save(UserJoinRequest user) {
        userRepository.save(user);
    }

    // read
    public User findById(Long id) {
        User user = userRepository.findById(id);
        return user;
    }

    public User findByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname);
        return user;
    }

    // update
    public void update(UserDto user) {
        userRepository.update(user);
    }

    // delete
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
