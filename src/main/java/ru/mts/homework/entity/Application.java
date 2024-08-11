package ru.mts.homework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    @Column(name = "start")
    private LocalDate startDate;
    /* @NotEmpty
    @Column(name = "employee_first_name")
    private LocalDate empFirstName;
    @NotEmpty
    @Column(name = "employee_second_name")
    private LocalDate empSecondName;
     */
}
