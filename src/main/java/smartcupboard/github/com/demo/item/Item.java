package smartcupboard.github.com.demo.item;

import lombok.Data;
import smartcupboard.github.com.demo.itemhistory.ItemHistory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rfid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "item")
    private List<ItemHistory> itemHistoryList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ItemStatus status;
}
