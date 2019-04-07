package smartcupboard.github.com.demo.device;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.shelf.Shelf;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Device {
    @Id
    private String id;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Shelf shelf;
}
