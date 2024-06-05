package br.com.samuel.apijunit5.services.impl;

import br.com.samuel.apijunit5.domain.User;
import br.com.samuel.apijunit5.domain.dto.UserDTO;
import br.com.samuel.apijunit5.repositories.UserRepository;
import br.com.samuel.apijunit5.services.UserService;
import br.com.samuel.apijunit5.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO dto) {
        return repository.save(mapper.map(dto, User.class));
    }
}
