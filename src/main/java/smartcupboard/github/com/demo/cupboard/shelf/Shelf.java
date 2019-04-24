package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.Cupboard;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;
import smartcupboard.github.com.demo.device.Device;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(optional = false)
    private Cupboard cupboard;

    @OneToMany(mappedBy = "shelf")
    private List<Sector> sectors = new ArrayList<>();

    @OneToOne(mappedBy = "shelf")
    private Device device;
}
