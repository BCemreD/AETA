package com.aeta.aeta.business.service;

import com.aeta.aeta.model.dto.UserDto;


import java.util.List;

public interface IUserService {

    UserDto createUser(UserDto dto);
    UserDto getUserById(Long id);
    UserDto getUserByName(String name);
    List<UserDto> getAllUsers() ;
}
