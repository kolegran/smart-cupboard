package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.Cupboard;

import javax.persistence.*;

@Entity
@Data
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(optional = false)
    private Cupboard cupboard;
}
