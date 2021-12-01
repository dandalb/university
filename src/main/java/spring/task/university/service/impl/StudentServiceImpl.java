package spring.task.university.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.task.university.model.Student;
import spring.task.university.repository.StudentRepository;
import spring.task.university.service.GroupService;
import spring.task.university.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupService groupService;

    public StudentServiceImpl(StudentRepository studentRepository,
                              GroupService groupService) {
        this.studentRepository = studentRepository;
        this.groupService = groupService;
    }

    @Override
    public Student get(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student save(Student student) {
        studentRepository.save(student);
        groupService.addStudent(student.getGroup(), student);//
        return student;
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
