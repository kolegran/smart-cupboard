package smartcupboard.github.com.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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

    @Transactional
    public UserDto create(CreateUpdateUserCommand command) {
        return saveUser(new User(), command);
    }

    @Transactional(readOnly = true)
    public UserDto getById(Long userId) {
        return new UserDto(userRepository.getOne(userId));
    }

    @Transactional(readOnly = true)
    public List<UserSimpleDto> getAll() {
        return userRepository.findAll()
            .stream()
            .map(UserSimpleDto::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public UserDto updateById(Long userId, CreateUpdateUserCommand command) {
        return saveUser(userRepository.getOne(userId), command);
    }

    @Transactional
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    private UserDto saveUser(User user, CreateUpdateUserCommand command) {
        user.setFirstName(command.getFirstName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());
        return new UserDto(userRepository.save(user));
    }
}
