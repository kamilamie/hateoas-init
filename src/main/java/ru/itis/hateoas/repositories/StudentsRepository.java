package ru.itis.hateoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.models.Student;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}