package smartcupboard.github.com.demo.rfid;

import lombok.Data;
import smartcupboard.github.com.demo.sample.Sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

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
}
