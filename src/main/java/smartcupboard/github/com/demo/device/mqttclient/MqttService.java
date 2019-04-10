package smartcupboard.github.com.demo.device.mqttclient;

import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MqttService {
    private final DeviceTransport deviceTransport = new DeviceTransport();

    public void sendMqttPackage() {
        try {
            deviceTransport.setConnection();
            IMqttClient publisher = deviceTransport.getPublisher();

            MqttMessage message = new MqttMessage("Hello Mqtt".getBytes());
            message.setQos(0);
            message.setRetained(true);
            publisher.publish("topic/hello",message);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
