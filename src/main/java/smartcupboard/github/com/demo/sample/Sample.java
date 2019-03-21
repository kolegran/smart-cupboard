package smartcupboard.github.com.demo.sample;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.Cupboard;
import smartcupboard.github.com.demo.cupboard.shelf.Shelf;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;
import smartcupboard.github.com.demo.rfid.Rfid;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp changedAt;

    private Timestamp deletedAt;

    @ManyToOne(optional = false)
    private Cupboard cupboard;

    @ManyToOne(optional = false)
    private Shelf shelf;

    @ManyToOne(optional = false)
    private Sector sector;

    @OneToOne
    private Rfid rfid;
}
