package smartcupboard.github.com.demo.cupboard;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateUpdateCupboardCommand {
    @Length(min = 1)
    private String title;
}
