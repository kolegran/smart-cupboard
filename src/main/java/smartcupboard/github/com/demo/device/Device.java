package smartcupboard.github.com.demo.device;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.shelf.Shelf;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class Device {
    @Id
    private String macAddress;

    @Column(nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private Timestamp createdAt;

    private String title;

    @ManyToOne
    private Shelf shelf;
}
