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
    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    // Test data
    UserForm userForm = new UserForm("Sheldon", "Cooper");

    @Test
    @DisplayName("User logged")
    void testLoginOk() {
        // Setting expectations (stubbing methods)
        when(loginService.login(userForm)).thenReturn(true);

        // Exercise SUT
        String reseponseLogin = loginController.login(userForm);

        // Verification
        assertEquals("OK", reseponseLogin);
        verify(loginService).login(userForm);
        verifyNoMoreInteractions(loginService);
    }

    @Test
    @DisplayName("User not logged")
    void testLoginKo() {
        // Setting expectations (stubbing methods)
        when(loginService.login(userForm)).thenReturn(false);

        // Exercise SUT
        String reseponseLogin = loginController.login(userForm);

        // Verification
        assertEquals("KO", reseponseLogin);
        verify(loginService).login(userForm);
        verifyZeroInteractions(loginService);
    }
    
    @Test
    @DisplayName("Null values. Login error")
    void testLoginError() {
        // Exercise
        String response = loginController.login(null);

        // Verify
        assertEquals("ERROR", response);
    }

    @Test
    @DisplayName("Login exception")
    void testLoginException() {
        // Expectation
        when(loginService.login(any(UserForm.class)))
                .thenThrow(IllegalArgumentException.class);

        // Exercise
        String response = loginController.login(userForm);

        // Verify
        assertEquals("ERROR", response);
    }

}
