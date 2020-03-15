package ru.itis.hateoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.models.Lesson;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}