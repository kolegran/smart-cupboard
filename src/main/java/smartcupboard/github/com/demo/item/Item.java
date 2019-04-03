package smartcupboard.github.com.demo.item;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;
import smartcupboard.github.com.demo.device.data.DeviceData;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "item")
    private List<DeviceData> deviceDataList = new ArrayList<>();
}