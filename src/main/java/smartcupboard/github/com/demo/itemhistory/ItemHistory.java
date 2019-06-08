package smartcupboard.github.com.demo.itemhistory;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;
import smartcupboard.github.com.demo.item.Item;
import smartcupboard.github.com.demo.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class ItemHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Timestamp createdAt;

    @ManyToOne(optional = false)
    private Sector sector;

    @ManyToOne(optional = false)
    private Item item;

    //@ManyToOne
    //private User user;
}
