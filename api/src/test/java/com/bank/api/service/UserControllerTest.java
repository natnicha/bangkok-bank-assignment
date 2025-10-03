package com.bank.api.service;

import com.bank.api.model.User;
import com.bank.api.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserService.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepo;

    private ObjectMapper objectMapper = new ObjectMapper();
    private User testUser;

    @BeforeEach
    public void setup() {
        testUser = new User(1L, "Test User", "TestUsername", "test@example.com", "123-456", "test.com");
    }

    // ===== GET /api/users?userId=1 =====
    @Test
    public void testGetUserById_Success() throws Exception {
        when(userRepo.getUserById(1L)).thenReturn(Optional.of(testUser));

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Leanne Graham"));

        verify(userRepo, times(1)).getUserById(1L);
    }

    @Test
    public void testGetUserById_NotFound() throws Exception {
        when(userRepo.getUserById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/user/3"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found with id: 3"));

        verify(userRepo, times(1)).getUserById(3L);
    }

}
