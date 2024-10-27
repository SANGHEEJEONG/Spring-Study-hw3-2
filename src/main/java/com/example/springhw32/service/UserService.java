package com.example.springhw32.service;

import com.example.springhw32.dto.UserDto;
import com.example.springhw32.entity.User;
import com.example.springhw32.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto join(UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());

        userRepository.save(newUser);
        return userDto;
    }

}
