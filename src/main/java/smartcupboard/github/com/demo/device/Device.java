package smartcupboard.github.com.demo.device;

import lombok.Data;
import smartcupboard.github.com.demo.device.data.DeviceData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Device {
    @Id
    private String id;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "device")
    private List<DeviceData> deviceDataList = new ArrayList<>();
}
