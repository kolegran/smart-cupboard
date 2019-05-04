package smartcupboard.github.com.demo.device.mqttclient;

import lombok.Getter;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter
public class DeviceTransport {
    private String clientId = UUID.randomUUID().toString();
    private IMqttClient client;

    public void setConnection() throws MqttException {
        MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence("dev/pahodata" + "/" + clientId);
        String mqttHost = System.getenv().getOrDefault("MQTT_HOST", "mosquitto-broker");
        client = new MqttClient("tcp://" + mqttHost+ ":1883", clientId, dataStore);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setKeepAliveInterval(30);
        options.setConnectionTimeout(60);
        client.connect(options);
    }
}
