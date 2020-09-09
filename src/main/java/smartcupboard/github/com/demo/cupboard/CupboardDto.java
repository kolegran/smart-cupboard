package smartcupboard.github.com.demo.cupboard;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;
import smartcupboard.github.com.demo.user.UserSimpleDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CupboardDto extends CupboardSimpleDto {
    private final List<ShelfSimpleDto> shelves;
    private final List<UserSimpleDto> users;

    public CupboardDto(Cupboard cupboard) {
        super(cupboard);

        this.shelves = cupboard.getShelves()
            .stream()
            .map(ShelfSimpleDto::new)
            .collect(Collectors.toList());
        this.users = cupboard.getUsers()
            .stream()
            .map(UserSimpleDto::new)
            .collect(Collectors.toList());
    }
}
