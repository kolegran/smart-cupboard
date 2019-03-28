package smartcupboard.github.com.demo.cupboard;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CupboardDto extends CupboardSimpleDto {
    private final List<ShelfSimpleDto> shelves;
    //private final List<UserDto> users;

    public CupboardDto(Cupboard cupboard) {
        super(cupboard);

        this.shelves = cupboard.getShelves()
                .stream()
                .map(ShelfSimpleDto::new)
                .collect(Collectors.toList());
    }
}
