package ru.mts.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mts.homework.Service.ApplicationService;
import ru.mts.homework.entity.Application;

@RestController
//@RequestMapping("/vacation")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/add")
    public String setRegString(@RequestBody @Validated Application app) {
        System.out.println(app.toString());
        applicationService.saveApplication(app);
        return "vac added";
    }
}
