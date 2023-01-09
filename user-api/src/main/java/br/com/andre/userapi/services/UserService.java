package br.com.andre.userapi.services;

import br.com.andre.userapi.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
}
