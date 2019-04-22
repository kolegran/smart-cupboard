package smartcupboard.github.com.demo.device.mqttclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import smartcupboard.github.com.demo.device.DeviceService;
import smartcupboard.github.com.demo.device.DeviceSimpleDto;
import smartcupboard.github.com.demo.device.EventDeviceCommand;
import smartcupboard.github.com.demo.device.RegistrationDeviceCommand;

@Component
@RequiredArgsConstructor
public class MqttController {
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
                    try {
                        DeviceSimpleDto deviceSimpleDto = deviceService.registration(new ObjectMapper().readValue(message.toString(), RegistrationDeviceCommand.class));
                        this.deviceTransport.getClient().publish("esp/token", deviceService.createMessage(deviceSimpleDto));
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.deviceTransport.getClient().publish("esp/error", new MqttMessage(new ObjectMapper().writeValueAsBytes(e.getMessage())));
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
