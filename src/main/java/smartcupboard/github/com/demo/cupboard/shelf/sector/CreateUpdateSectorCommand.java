package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateSectorCommand {
    @NotNull
    private Long shelfId;

    @NotNull
    private Long sampleId;
}
