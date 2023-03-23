package user;

import com.breallencs.mytripyapi.modules.user.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void constructor_shouldSetAttributes() {
        String name = "Ansi Lacerda";
        String username = "AnsiLacerda";
        String email = "Ansilacerda@wavelacerda.com";
        String password = "Password";
        LocalDateTime createdAt = LocalDateTime.parse("2007-12-03T10:15:30");
        boolean isActive = true;

        User user = new User(name, username, email, password,createdAt,isActive);

        assertEquals(isActive, user.getActive());
        assertEquals(name, user.getName());
        assertEquals(username, user.getUsername());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(0L, user.getId());

    }
}
