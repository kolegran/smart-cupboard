package smartcupboard.github.com.demo.reader;

import lombok.Getter;

@Getter
public class ReaderSimpleDto {
    private final String id;
    private final String title;

    public ReaderSimpleDto(Reader reader) {
        this.id = reader.getId();
        this.title = reader.getTitle();
    }
}
