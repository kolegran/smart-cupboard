package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.CupboardSimpleDto;

@Getter
public class ShelfSimpleDto {
    private final Long id;
    private final String title;
    private final CupboardSimpleDto cupboard;

    public ShelfSimpleDto(Shelf shelf) {
        this.id = shelf.getId();
        this.title = shelf.getTitle();
        this.cupboard = new CupboardSimpleDto(shelf.getCupboard());
    }
}
