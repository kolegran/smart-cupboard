package smartcupboard.github.com.demo.device.mqttclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smartcupboard.github.com.demo.device.EventDeviceCommand;

@RequiredArgsConstructor
@Service
public class MqttService {

    public void sendMqttPackage() {
    }

    public void receiveMqttPackage(String topic, EventDeviceCommand command) {
    }
}
