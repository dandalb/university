package spring.task.university.service;

import java.util.List;
import spring.task.university.model.Lecture;

public interface LectureService {
    Lecture get(Long id);

    Lecture save(Lecture lecture);

    void delete(Lecture lecture);

    List<Lecture> findAll();
}
