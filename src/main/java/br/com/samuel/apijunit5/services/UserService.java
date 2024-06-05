package br.com.samuel.apijunit5.services;

import br.com.samuel.apijunit5.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
