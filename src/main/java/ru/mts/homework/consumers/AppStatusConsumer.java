package ru.mts.homework.consumers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.mts.homework.dto.ApplicationStatus;
import ru.mts.homework.service.ApplicationService;

@Component
public class AppStatusConsumer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApplicationService applicationService;

    @KafkaListener(topics = "application.status", groupId = "consumer-2")
    public void consumeTest(ApplicationStatus appStatus) {
        logger.info("Application service consume application.status message:  {}", appStatus);
        applicationService.updateApplicationStatus(appStatus);

    }
}
