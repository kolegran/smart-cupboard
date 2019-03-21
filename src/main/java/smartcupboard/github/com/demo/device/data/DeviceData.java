package smartcupboard.github.com.demo.device.data;

import lombok.Data;
import smartcupboard.github.com.demo.device.Device;
import smartcupboard.github.com.demo.rfid.Rfid;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class DeviceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Timestamp createdAt;

    @ManyToOne(optional = false)
    private Device device;

    @ManyToOne(optional = false)
    private Rfid rfid;

    @Column(nullable = false)
    private Double value;
}
