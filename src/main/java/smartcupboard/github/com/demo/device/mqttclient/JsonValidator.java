package smartcupboard.github.com.demo.device.mqttclient;

import org.springframework.stereotype.Component;
import smartcupboard.github.com.demo.device.EventDeviceCommand;
import smartcupboard.github.com.demo.device.ItemData;
import smartcupboard.github.com.demo.device.ReaderData;

@Component
public class JsonValidator {
    public void validate(EventDeviceCommand eventDeviceCommand) {
        for (ReaderData reader : eventDeviceCommand.getReaders()) {
            for (ItemData item : reader.getItems()) {
                if (item.getRfid().isEmpty() || item.getRfid().isBlank()) {
                    throw new IllegalStateException("RFID is not valid");
                }
            }
        }
    }
}
