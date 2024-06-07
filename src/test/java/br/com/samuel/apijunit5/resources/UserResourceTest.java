package br.com.samuel.apijunit5.resources;

import br.com.samuel.apijunit5.domain.User;
import br.com.samuel.apijunit5.domain.dto.UserDTO;
import br.com.samuel.apijunit5.repositories.UserRepository;
import br.com.samuel.apijunit5.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserResourceTest {

    @InjectMocks
    private UserResource resource;
    @Mock
    private UserService service;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyInt())).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resource.findById(1);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(1, response.getBody().getId());
        assertEquals("samuel", response.getBody().getName());
        assertEquals("samuel@gmail.com", response.getBody().getEmail());
        assertEquals("1234", response.getBody().getPassword());

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

    private void startUser() {
        user = new User(1, "samuel", "samuel@gmail.com", "1234");
        userDTO = new UserDTO(1, "samuel", "samuel@gmail.com", "1234");
    }
}