package smartcupboard.github.com.demo.device.mqttclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import smartcupboard.github.com.demo.device.DeviceService;
import smartcupboard.github.com.demo.device.DeviceSimpleDto;
import smartcupboard.github.com.demo.device.EventDeviceCommand;
import smartcupboard.github.com.demo.device.RegistrationDeviceCommand;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class MqttController {
    private CountDownLatch receivedSignal = new CountDownLatch(10);

    private final DeviceTransport deviceTransport = new DeviceTransport();

    private final DeviceService deviceService;

    @EventListener(ApplicationReadyEvent.class)
    public void onLoad() {
        subscribeOnTopic();
    }

    public void subscribeOnTopic() {
        try {
            this.deviceTransport.setConnection();

            this.deviceTransport.getClient().subscribe("esp/#", (topic, message) -> {
                if (topic.contains("/event")) {
                    deviceService.addEvents(new ObjectMapper().readValue(message.toString(), EventDeviceCommand.class));
                } else if (topic.contains("/registration")) {
                    DeviceSimpleDto deviceSimpleDto = deviceService.registration(new ObjectMapper().readValue(message.toString(), RegistrationDeviceCommand.class));
                    this.deviceTransport.getClient().publish("esp/token", deviceService.createMessage(deviceSimpleDto));
                }
                this.receivedSignal.countDown();
            });
            this.receivedSignal.await(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
