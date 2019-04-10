package smartcupboard.github.com.demo.device.mqttclient;

import lombok.Getter;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter
public class DeviceTransport {
    private String publisherId = UUID.randomUUID().toString();
    private IMqttClient publisher;

    public void setConnection() throws MqttException {
            publisher = new MqttClient("tcp://stag.track-debts.com:1883", publisherId);

            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            publisher.connect(options);
    }
}
