
package psa.doubles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import psa.doubles.LoginRepository;
import psa.doubles.LoginService;
import psa.doubles.UserForm;

@ExtendWith(MockitoExtension.class)
class LoginServiceSpyTest {

    @InjectMocks
    LoginService loginService;

    @Spy
    LoginRepository loginRepository;

    UserForm userOk = new UserForm("user1", "p1");
    UserForm userKo = new UserForm("foo", "bar");

    @Test
    void testLoginOk() {
        assertTrue(loginService.login(userOk));
        verify(loginRepository,times(1)).login(userOk);
    }

    @Test
    void testLoginKo() {
        assertFalse(loginService.login(userKo));
        verify(loginRepository,times(1)).login(userKo);
    }

}
