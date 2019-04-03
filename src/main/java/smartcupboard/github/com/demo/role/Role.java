package smartcupboard.github.com.demo.role;

import lombok.Data;
import smartcupboard.github.com.demo.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    private List<Permission> permissions = new ArrayList<>();

    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();
}
