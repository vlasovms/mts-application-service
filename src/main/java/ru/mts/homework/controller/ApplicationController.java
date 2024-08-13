package ru.mts.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mts.homework.service.ApplicationService;
import ru.mts.homework.entity.Application;
import ru.mts.homework.producers.ApplicationProducer;

@RestController
@RequestMapping("/vacation")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @Autowired
    ApplicationProducer applicationProducer;

    @PostMapping("/add")
    public ResponseEntity<String> applicationAdd(@RequestBody @Validated Application app) {
        app.setStatus("new");
        applicationService.saveApplication(app);
        applicationProducer.sendToKafka(app);
        return ResponseEntity.ok("Application created and kafka message sended");
    }
}
