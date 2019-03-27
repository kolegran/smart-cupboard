package smartcupboard.github.com.demo.cupboard;

import lombok.Getter;

@Getter
public class CupboardSimpleDto {
    private final Long id;
    private final String title;

    public CupboardSimpleDto(Cupboard cupboard) {
        this.id = cupboard.getId();
        this.title = cupboard.getTitle();
    }
}
