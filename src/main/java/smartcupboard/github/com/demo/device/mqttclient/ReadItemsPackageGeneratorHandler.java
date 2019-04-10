package smartcupboard.github.com.demo.device.mqttclient;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReadItemsPackageGeneratorHandler {

    @EventListener
    public void onReadItemEvent(ReadItemsEvent event) {

    }
}
