package spring.task.university.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spring.task.university.model.Group;
import spring.task.university.model.Student;
import spring.task.university.repository.StudentRepository;
import spring.task.university.service.impl.StudentServiceImpl;

class StudentServiceTest {
    private static Student student;
    private static List<Student> studentList;
    private StudentRepository studentRepository;
    private StudentService studentService;
    private GroupService groupService;

    @BeforeAll
    static void beforeAll() {
        student = new Student();
        student.setId(1L);
        student.setGroup(new Group());
        student.setName("Pavlo");
        student.setLastName("Ivanov");
        studentList = List.of(student);
    }

    @BeforeEach
    void setUp() {
        studentRepository = Mockito.mock(StudentRepository.class);
        groupService = Mockito.mock(GroupService.class);
        studentService = new StudentServiceImpl(studentRepository, groupService);
    }

    @Test
    void get() {
        Mockito.when(studentRepository.getById(1L)).thenReturn(student);
        Student actual = studentService.get(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(student, actual);
    }

    @Test
    void save() {
        Mockito.when(studentRepository.save(student)).thenReturn(student);
        Student actual = studentService.save(student);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(student, actual);
    }

    @Test
    void findAll() {
        Mockito.when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> actualList = studentService.findAll();
        Assertions.assertEquals(1, actualList.size());
        Assertions.assertEquals(student, actualList.get(0));
    }
}