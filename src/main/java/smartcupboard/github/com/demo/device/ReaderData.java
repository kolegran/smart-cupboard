package smartcupboard.github.com.demo.device;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReaderData {
    private String readerId;
    private List<ItemData> items = new ArrayList<>();
}
