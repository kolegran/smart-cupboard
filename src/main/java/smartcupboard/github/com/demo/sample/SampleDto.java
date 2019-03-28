package smartcupboard.github.com.demo.sample;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorDto;

import java.sql.Timestamp;

@Getter
public class SampleDto {
    private final Long id;
    private final String title;
    private final Timestamp createdAt;
    private final Timestamp changedAt;
    private final Timestamp deletedAt;

    private final SectorDto sector;
    //private final RfidDto rfid;

    public SampleDto(Sample sample) {
        this.id = sample.getId();
        this.title = sample.getTitle();
        this.createdAt = sample.getCreatedAt();
        this.changedAt = sample.getChangedAt();
        this.deletedAt = sample.getDeletedAt();

        this.sector = new SectorDto(sample.getSector());
    }
}
