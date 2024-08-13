package ru.mts.homework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.homework.ApplicationStatus;
import ru.mts.homework.entity.Application;
import ru.mts.homework.repository.ApplicationRepository;

import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void saveApplication(Application app) {
        applicationRepository.save(app);
    }

    public void updateApplicationStatus(ApplicationStatus applicationStatus) {
        Application application = applicationRepository.findById(applicationStatus.getId()).orElse(null);
        if (application != null) {
            application.setStatus(applicationStatus.getStatus());
            application.setComment(applicationStatus.getComment());
            applicationRepository.save(application);
            logger.info("Application with id: " + applicationStatus.getId() + " updated; Current status: " + applicationStatus.getStatus());
        } else {
            logger.info("Application with id: " + applicationStatus.getId() + " not found!");
        }

    }
}
