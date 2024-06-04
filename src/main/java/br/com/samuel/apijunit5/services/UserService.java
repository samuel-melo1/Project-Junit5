package br.com.samuel.apijunit5.services;

import br.com.samuel.apijunit5.domain.User;

public interface UserService {

    User findById(Integer id);
}
