package tp3.exo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserById() {

        UserRepository userRepositoryMock = mock(UserRepository.class);


        UserService userService = new UserService(userRepositoryMock);


        long userId = 1L;
        User expectedUser = new User(userId, "saker youcef");
        when(userRepositoryMock.findUserById(userId)).thenReturn(expectedUser);


        User result = userService.getUserById(userId);


        assertEquals(expectedUser, result);


        verify(userRepositoryMock).findUserById(userId);
    }
}