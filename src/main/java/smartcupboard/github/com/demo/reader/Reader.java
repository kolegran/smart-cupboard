package smartcupboard.github.com.demo.reader;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Reader {
    @Id
    private String id;

    private String title;

    @OneToOne
    private Sector sector;
}
