package be.cbsaintlaurent.appdubleu.backend.user.service;

import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import be.cbsaintlaurent.appdubleu.backend.user.mapper.StLoUserMapper;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StLoUserService {

    private final StLoUserRepository userRepository;
    private final StLoUserMapper userMapper;

    public List<StLoUser> getAllUsernames() {
        var response = userRepository.findAll();
        return userMapper.toUsernameOnlyDtoList(response);
    }

    // TODO : retrieve/ edit profile
    // TODO : List user
    // TODO : Change password (pas forgot, change)
    // TODO : Delete user
}
