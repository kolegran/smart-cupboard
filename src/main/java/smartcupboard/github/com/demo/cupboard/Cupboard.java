package smartcupboard.github.com.demo.cupboard;

import lombok.Data;
import smartcupboard.github.com.demo.cupboard.shelf.Shelf;
import smartcupboard.github.com.demo.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cupboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "cupboard")
    private List<Shelf> shelves = new ArrayList<>();

    @ManyToMany
    private List<User> users = new ArrayList<>();
}
