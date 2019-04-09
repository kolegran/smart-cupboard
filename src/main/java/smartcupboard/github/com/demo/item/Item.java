package smartcupboard.github.com.demo.item;

import lombok.Data;
import smartcupboard.github.com.demo.itemhistory.ItemHistory;

import javax.persistence.*;
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
