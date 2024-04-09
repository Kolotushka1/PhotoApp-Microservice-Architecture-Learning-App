package com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.service;

import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetails);
}
