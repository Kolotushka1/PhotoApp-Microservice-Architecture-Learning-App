package com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.service;

import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.data.UserEntity;
import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.data.UserRepository;
import com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
        userEntity.setEncryptedPassword("test");

        userRepository.save(userEntity);

        return modelMapper.map(userEntity, UserDto.class);
    }
}
