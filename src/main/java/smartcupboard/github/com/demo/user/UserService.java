package smartcupboard.github.com.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    public Object obtainToken(ObtainTokenCommand command) {
        return null;
    }

    public void createPassword(ForgotPasswordCommand command) {
    }

    public UserExtendedDto getUserById(Long userId) {
        return null;
    }

    public UserDto updateUserById(UserRequestContext context, UpdateUserInfoCommand command) {
        return null;
    }

    public void changePassword(UserRequestContext context, ChangePasswordCommand command) {
    }

    public UserDto create(CreateUserCommand command) {
        return null;
    }

    public UserDto getById(Long userId) {
        return null;
    }

    public List<UserDto> getAll() {
        return null;
    }

    public UserDto updateById(Long userId, UpdateUserCommand command) {
        return null;
    }

    public void deleteById(Long userId) {
    }
}
