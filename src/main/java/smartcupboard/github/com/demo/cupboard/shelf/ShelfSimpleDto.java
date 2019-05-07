package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Getter;

@Getter
public class ShelfSimpleDto {
    private final Long id;
    private final String title;

    public ShelfSimpleDto(Shelf shelf) {
        this.id = shelf.getId();
        this.title = shelf.getTitle();
    }
}
