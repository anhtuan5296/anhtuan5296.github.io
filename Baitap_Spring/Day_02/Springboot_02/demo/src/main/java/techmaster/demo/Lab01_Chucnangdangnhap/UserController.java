package techmaster.demo.Lab01_Chucnangdangnhap;

import com.example.userauthdemo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        // Replace this with actual user authentication logic
        if ("username".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            User loggedInUser = new User(1, "username", "email@example.com", "", "avatar.jpg");
            return ResponseEntity.ok(new LoggedInUser(loggedInUser.getUsername(), loggedInUser.getEmail(), loggedInUser.getAvatar()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username or password incorrect");
        }
    }
}
