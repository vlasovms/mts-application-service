package ru.mts.homework.consumers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import ru.mts.homework.ApplicationStatus;
import ru.mts.homework.service.ApplicationService;

@Configuration
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
