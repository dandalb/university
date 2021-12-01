package spring.task.university.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.task.university.model.Lecture;
import spring.task.university.repository.LectureRepository;
import spring.task.university.service.LectureService;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Lecture get(Long id) {
        return lectureRepository.getById(id);
    }

    @Override
    public Lecture save(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public void delete(Lecture lecture) {
        lectureRepository.delete(lecture);
    }

    @Override
    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }
}
