package ru.mts.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.homework.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
