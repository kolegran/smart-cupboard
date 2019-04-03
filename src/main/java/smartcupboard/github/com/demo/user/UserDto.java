package smartcupboard.github.com.demo.user;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.CupboardSimpleDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserDto extends UserSimpleDto {
    private final List<CupboardSimpleDto> cupboards;

    public UserDto(User user) {
        super(user);

        this.cupboards = user.getCupboards()
                .stream()
                .map(CupboardSimpleDto::new)
                .collect(Collectors.toList());
    }
}
