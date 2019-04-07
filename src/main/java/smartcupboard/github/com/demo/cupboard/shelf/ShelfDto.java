package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.CupboardSimpleDto;

@Getter
public class ShelfDto extends ShelfSimpleDto {
    private final CupboardSimpleDto cupboard;

    public ShelfDto(Shelf shelf) {
        super(shelf);

        this.cupboard = new CupboardSimpleDto(shelf.getCupboard());
    }
}
