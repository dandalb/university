package spring.task.university.service;

import java.util.List;
import spring.task.university.model.Student;

public interface StudentService {
    Student get(Long id);

    Student save(Student student);

    void delete(Student student);

    List<Student> findAll();
}
