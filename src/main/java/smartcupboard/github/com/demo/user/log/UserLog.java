package smartcupboard.github.com.demo.user.log;

import lombok.Data;
import smartcupboard.github.com.demo.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp createdAt;

    @ManyToOne(optional = false)
    private User user;
}
