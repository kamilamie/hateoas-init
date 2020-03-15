package ru.itis.hateoas.services;

import ru.itis.hateoas.models.Course;

public interface CoursesService {
    Course publish(Long courseId);
}