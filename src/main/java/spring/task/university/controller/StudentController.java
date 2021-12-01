package spring.task.university.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.task.university.dto.request.StudentRequestDto;
import spring.task.university.dto.response.StudentResponseDto;
import spring.task.university.service.StudentService;
import spring.task.university.service.mapper.StudentMapper;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentMapper studentMapper;
    private final StudentService studentService;

    public StudentController(StudentService studentService,
                             StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public List<StudentResponseDto> getAll() {
        return studentService.findAll()
                .stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public StudentResponseDto add(@RequestBody @Valid StudentRequestDto studentRequestDto) {
        return studentMapper.mapToDto(studentService.save(
                studentMapper.mapToModel(studentRequestDto)));
    }
}
