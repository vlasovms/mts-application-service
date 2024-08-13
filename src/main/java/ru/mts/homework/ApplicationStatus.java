package ru.mts.homework;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ApplicationStatus {
    private Long id;
    private String comment;
    private String status;
}
