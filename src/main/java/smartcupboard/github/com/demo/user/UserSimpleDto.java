package smartcupboard.github.com.demo.user;

import lombok.Getter;
import smartcupboard.github.com.demo.role.RoleSimpleDto;

@Getter
public class UserSimpleDto {
    private final Long id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final RoleSimpleDto role;

    public UserSimpleDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.role = new RoleSimpleDto(user.getRole());
    }
}
