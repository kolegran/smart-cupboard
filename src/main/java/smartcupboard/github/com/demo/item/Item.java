package smartcupboard.github.com.demo.item;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Item {
    @Id
    private String id;

    private String title;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp changedAt;

    private Timestamp deletedAt;

    @OneToOne(optional = false)
    private Sector sector;
}
