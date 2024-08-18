package ru.mts.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mts.homework.service.ApplicationService;
import ru.mts.homework.entity.Application;
import ru.mts.homework.producers.ApplicationProducer;

import java.util.List;

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

    @GetMapping("/getAll")
    public ResponseEntity<List<Application>> getAll() {
        List<Application> applications = applicationService.getAll();
        return ResponseEntity.ok(applications);
    }
}
