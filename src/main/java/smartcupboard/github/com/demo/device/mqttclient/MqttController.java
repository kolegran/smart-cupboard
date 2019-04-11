package smartcupboard.github.com.demo.device.mqttclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import smartcupboard.github.com.demo.device.EventDeviceCommand;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class MqttController {
    private final DeviceTransport deviceTransport = new DeviceTransport();
    private CountDownLatch receivedSignal = new CountDownLatch(10);

    private final MqttService mqttService;

    @EventListener(ApplicationReadyEvent.class)
    public void onLoad() {
        subscribeOnTopic();
    }

    public void subscribeOnTopic() {
        try {
            this.deviceTransport.setConnection();

            this.deviceTransport.getClient().subscribe("esp/#", (topic, message) -> {
                this.mqttService.receiveMqttPackage(topic, new ObjectMapper().readValue(message.toString(), EventDeviceCommand.class));
                this.receivedSignal.countDown();
            });

            this.receivedSignal.await(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
