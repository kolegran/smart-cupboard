package smartcupboard.github.com.demo.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequestContext {
    private final long id;
}
