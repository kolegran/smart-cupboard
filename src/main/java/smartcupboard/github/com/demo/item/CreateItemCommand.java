package smartcupboard.github.com.demo.item;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class CreateItemCommand {
    @Length(min = 1)
    private String title;

    private long createdAt;

    private long changedAt;

    private long deletedAt;

    @NotNull
    private Long sectorId;
}
