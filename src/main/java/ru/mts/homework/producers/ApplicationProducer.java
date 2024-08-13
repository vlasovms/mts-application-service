package ru.mts.homework.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.mts.homework.entity.Application;

@Component
public class ApplicationProducer {

    @Autowired
    private KafkaTemplate<String, Application> kafkaTemplate;

    public void sendToKafka(final Application data) {
        kafkaTemplate.send("application", data);
    }
}
