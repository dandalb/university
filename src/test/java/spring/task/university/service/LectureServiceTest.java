package spring.task.university.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spring.task.university.model.Audience;
import spring.task.university.model.Lecture;
import spring.task.university.repository.LectureRepository;
import spring.task.university.service.impl.LectureServiceImpl;

class LectureServiceTest {
    private static Lecture lecture;
    private static List<Lecture> lectureList;
    private LectureRepository lectureRepository;
    private LectureService lectureService;

    @BeforeAll
    static void beforeAll() {
        lecture = new Lecture();
        lecture.setId(1L);
        lecture.setAudience(new Audience());
        lecture.setName("History");
        lectureList = List.of(lecture);
    }

    @BeforeEach
    void setUp() {
        lectureRepository = Mockito.mock(LectureRepository.class);
        lectureService = new LectureServiceImpl(lectureRepository);
    }

    @Test
    void get_Ok() {
        Mockito.when(lectureRepository.getById(1L)).thenReturn(lecture);
        Lecture actual = lectureService.get(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(lecture, actual);
    }

    @Test
    void save() {
        Mockito.when(lectureRepository.save(lecture)).thenReturn(lecture);
        Lecture actual = lectureService.save(lecture);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(lecture, actual);
    }

    @Test
    void findAll() {
        Mockito.when(lectureRepository.findAll()).thenReturn(lectureList);
        List<Lecture> actualList = lectureService.findAll();
        Assertions.assertEquals(1, actualList.size());
        Assertions.assertEquals(lecture, actualList.get(0));
    }
}