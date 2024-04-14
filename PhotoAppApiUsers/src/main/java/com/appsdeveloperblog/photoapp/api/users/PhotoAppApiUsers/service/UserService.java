package com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.service;

import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
}
