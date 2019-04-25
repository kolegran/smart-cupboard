package smartcupboard.github.com.demo.user;

import lombok.Getter;

@Getter
public class UserSimpleDto {
    private final Long id;
    private final String email;
    private final String firstName;
    private final String lastName;

    public UserSimpleDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
