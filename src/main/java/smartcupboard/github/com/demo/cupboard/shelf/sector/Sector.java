package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.shelf.Shelf;
import smartcupboard.github.com.demo.reader.Reader;

import javax.persistence.*;

@Entity
@Data
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(optional = false)
    private Shelf shelf;

    @OneToOne(mappedBy = "sector")
    private Reader reader;
}
