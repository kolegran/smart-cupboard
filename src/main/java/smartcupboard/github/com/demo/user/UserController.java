package smartcupboard.github.com.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authorization(@RequestBody @Valid ObtainTokenCommand command) {
        return ResponseEntity.ok(userService.obtainToken(command));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestBody @Valid ForgotPasswordCommand command) {
        userService.createPassword(command);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/current")
    public ResponseEntity<UserExtendedDto> getCurrentUserById(@ApiIgnore UserRequestContext context) {
        return ResponseEntity.ok(userService.getUserById(context.getId()));
    }

    @PutMapping("/users/current")
    public ResponseEntity<UserDto> updateCurrentUserById(@ApiIgnore UserRequestContext context,
                                                  @RequestBody @Valid UpdateUserInfoCommand command) {
        return ResponseEntity.ok(userService.updateUserById(context, command));
    }

    @PostMapping("/users/current/change-password")
    public ResponseEntity<Void> changeUserPassword(@ApiIgnore UserRequestContext context,
                                                   @RequestBody @Valid ChangePasswordCommand command) {
        userService.changePassword(context, command);
        return ResponseEntity.ok().build();
    }

    // Admin

    @PostMapping("/users/invite")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid CreateUpdateUserCommand command) {
        return ResponseEntity.ok(userService.create(command));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getById(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable Long userId,
                                                  @RequestBody @Valid CreateUpdateUserCommand command) {
        return ResponseEntity.ok(userService.updateById(userId, command));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
