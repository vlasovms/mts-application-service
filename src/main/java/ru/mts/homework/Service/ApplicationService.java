package ru.mts.homework.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.homework.entity.Application;
import ru.mts.homework.repository.ApplicationRepository;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    public void saveApplication(Application app) {
        applicationRepository.save(app);
    }
}
