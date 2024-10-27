package com.example.springhw32.controller;

import com.example.springhw32.dto.UserDto;
import com.example.springhw32.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping
    public UserDto join(@ModelAttribute UserDto userDto) {
        return userService.join(userDto);
    }
}

