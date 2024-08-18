package ru.mts.homework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class Application {
    @Id
    @SequenceGenerator(name = "application_id_seq", sequenceName = "application_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "application_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "start_date")
    private LocalDate startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(name = "end_date")
    private LocalDate endDate;
    @NotEmpty
    @Column(name = "employee_first_name")
    private String empFirstName;
    @NotEmpty
    @Column(name = "employee_second_name")
    private String empSecondName;
    @JsonIgnore
    @Column(name = "decision_comment")
    private String comment;
    @JsonIgnore
    private String status;
}
