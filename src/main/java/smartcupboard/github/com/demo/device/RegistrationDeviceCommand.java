package smartcupboard.github.com.demo.device;

import lombok.Data;

@Data
public class RegistrationDeviceCommand {
    private String title;

    private String macAddress;
}
