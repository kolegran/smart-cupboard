package smartcupboard.github.com.demo.rfid;

import lombok.Data;
import smartcupboard.github.com.demo.device.data.DeviceData;
import smartcupboard.github.com.demo.sample.Sample;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Rfid {
    @Id
    @NotNull
    private String id;

    @Column(nullable = false)
    private Timestamp createdAt;

    @OneToOne(mappedBy = "rfid")
    private Sample sample;

    @OneToMany(mappedBy = "rfid")
    private List<DeviceData> deviceDataList = new ArrayList<>();
}
