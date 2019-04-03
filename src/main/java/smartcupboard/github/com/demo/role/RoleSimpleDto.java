package smartcupboard.github.com.demo.role;

import lombok.Getter;

@Getter
public class RoleSimpleDto {
    private final Long id;
    private final String title;

    public RoleSimpleDto(Role role) {
        this.id = role.getId();
        this.title = role.getTitle();
    }
}
