package br.com.samuel.apijunit5.services.impl;

import br.com.samuel.apijunit5.domain.User;
import br.com.samuel.apijunit5.domain.dto.UserDTO;
import br.com.samuel.apijunit5.repositories.UserRepository;
import br.com.samuel.apijunit5.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;
    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);
        User response = service.findById(1);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(1, response.getId());
        assertEquals("samuel",response.getName());
        assertEquals("samuel@gmail.com", response.getEmail());

    }
    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException(){
        when(repository.findById(anyInt())).thenThrow( new ObjectNotFoundException("Objeto não encontrado"));

        try {
            service.findById(1);
        }catch (Exception e){
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals("Objeto não encontrado", e.getMessage());
        }
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(1, "samuel", "samuel@gmail.com", "1234");
        userDTO = new UserDTO(1, "samuel", "samuel@gmail.com", "1234");
        optionalUser = Optional.of(new User(1, "samuel", "samuel@gmail.com", "1234"));
    }
}