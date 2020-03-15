package ru.itis.hateoas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.hateoas.models.Course;
import ru.itis.hateoas.models.Lesson;
import ru.itis.hateoas.models.Student;
import ru.itis.hateoas.repositories.CoursesRepository;
import ru.itis.hateoas.repositories.LessonsRepository;
import ru.itis.hateoas.repositories.StudentsRepository;

import java.util.Collections;

import static java.util.Arrays.asList;

@SpringBootApplication
public class HateoasApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HateoasApplication.class, args);


        CoursesRepository coursesRepository = context.getBean(CoursesRepository.class);
        LessonsRepository lessonsRepository = context.getBean(LessonsRepository.class);
        StudentsRepository studentsRepository = context.getBean(StudentsRepository.class);

        Course javaLab = Course.builder()
                .description("Курс по разработке на Java")
                .title("JavaLab")
                .state("Deleted")
                .build();

        Course dataLab = Course.builder()
                .description("Курс по Базам данных")
                .title("DataLab")
                .state("Draft")
                .build();

        coursesRepository.saveAll(asList(
                javaLab, dataLab
        ));

        Lesson firstJavaLabLesson = Lesson.builder()
                .title("Rest Data Repository")
                .rate(100)
                .course(javaLab)
                .build();

        Lesson secondJavaLabLesson = Lesson.builder()
                .title("HATEOAS")
                .rate(1)
                .course(javaLab)
                .build();

        Lesson firstDataLabLesson = Lesson.builder()
                .title("Парсим сайты")
                .rate(100)
                .course(dataLab)
                .build();

        Lesson secondDataLabLesson = Lesson.builder()
                .title("Что-то с таблицами они проходили")
                .rate(146)
                .course(dataLab)
                .build();

        lessonsRepository.saveAll(asList(firstJavaLabLesson,
                secondJavaLabLesson,
                firstDataLabLesson,
                secondDataLabLesson));

        Student daria = Student.builder()
                .firstName("Дария")
                .lastName("Шагиева")
                .courses(asList(javaLab, dataLab))
                .build();

        Student emil = Student.builder()
                .firstName("Эмиль")
                .lastName("Аминов")
                .courses(Collections.singletonList(javaLab))
                .build();

        studentsRepository.saveAll(asList(emil, daria));

    }
}
