package smartcupboard.github.com.demo.user;

import lombok.*;
import smartcupboard.github.com.demo.cupboard.Cupboard;
import smartcupboard.github.com.demo.role.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @OneToOne
    private Role role;

    @ManyToMany(mappedBy = "users")
    private List<Cupboard> cupboards = new ArrayList<>();
}
