package se.mehdi.securewebapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(GrupparbeteController.class)
public class GrupparbeteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void testLoggedInEndpoint() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("loggedIn"));
    }

    @Test
    public void testRegisterEndpoint() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("user"));
    }

    @Test
    public void testAdminEndpoint() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin"));
    }

    @Test
    public void testLoggedOutEndpoint() throws Exception {
        mockMvc.perform(get("/logged-out"))
                .andExpect(status().isOk())
                .andExpect(view().name("loggedOut"));
    }
}
