package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.CupboardSimpleDto;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorDto;
import smartcupboard.github.com.demo.sample.SampleDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ShelfDto extends ShelfSimpleDto {
    private final CupboardSimpleDto cupboard;
    private final List<SectorDto> sectors;
    private final List<SampleDto> samples;

    public ShelfDto(Shelf shelf) {
        super(shelf);

        this.cupboard = new CupboardSimpleDto(shelf.getCupboard());

        this.sectors = shelf.getSectors()
                .stream()
                .map(SectorDto::new)
                .collect(Collectors.toList());

        this.samples = shelf.getSamples()
                .stream()
                .map(SampleDto::new)
                .collect(Collectors.toList());
    }
}
