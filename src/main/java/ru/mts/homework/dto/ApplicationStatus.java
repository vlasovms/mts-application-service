package ru.mts.homework.dto;

import lombok.Data;

@Data
public class ApplicationStatus {
    private Long id;
    private String comment;
    private String status;
}
