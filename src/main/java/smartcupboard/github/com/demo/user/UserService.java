package smartcupboard.github.com.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.role.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    RoleRepository roleRepository;
    UserRepository userRepository;

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
        User user = new User();
        user.setFirstName(command.getFirstName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());
        user.setRole(roleRepository.getOne(command.getRoleId()));

        return new UserDto(userRepository.save(user));
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
        User user = userRepository.getOne(userId);

        user.setFirstName(command.getFirstName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());
        user.setRole(roleRepository.getOne(command.getRoleId()));

        return new UserDto(userRepository.save(user));
    }

    @Transactional
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
