package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.auth.UserDto;
import com.aeta.aeta.model.dto.auth.UserRegisterRequestDto;
import com.aeta.aeta.model.entity.User;


import java.util.List;

public interface IUserService {

    UserDto createUser(UserRegisterRequestDto request);
    UserDto getUserById(Long id);
    UserDto getUserByName(String name);
    List<UserDto> getAllUsers() ;
    User getUserEntityByUsername(String username);

}
