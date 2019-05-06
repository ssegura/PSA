package psa.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import psa.doubles.LoginService;
import psa.doubles.UserForm;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    // Mocking objects
	// TODO
	
    // Test data
    UserForm userForm = new UserForm("Sheldon", "Cooper");

    @Test
    @DisplayName("User logged")
    void testLoginOk() {
        // TODO

    }

    @Test
    @DisplayName("User not logged")
    void testLoginKo() {
        // TODO
    }
    
    @Test
    @DisplayName("Null values. Login error")
    void testLoginError() {
        // TODO
    }

    @Test
    @DisplayName("Login exception")
    void testLoginException() {
        // TODO
    }

}
