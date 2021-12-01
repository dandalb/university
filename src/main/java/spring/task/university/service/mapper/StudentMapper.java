package spring.task.university.service.mapper;

import org.springframework.stereotype.Component;
import spring.task.university.dto.request.StudentRequestDto;
import spring.task.university.dto.response.StudentResponseDto;
import spring.task.university.model.Student;
import spring.task.university.service.GroupService;

@Component
public class StudentMapper implements ResponseDtoMapper<StudentResponseDto, Student>,
        RequestDtoMapper<Student, StudentRequestDto> {
    private final GroupService groupService;

    public StudentMapper(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public Student mapToModel(StudentRequestDto dto) {
        Student student = new Student();
        student.setGroup(groupService.get(dto.getGroupId()));
        student.setName(dto.getName());
        student.setLastName(dto.getLastName());
        return student;
    }

    @Override
    public StudentResponseDto mapToDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setGroupId(student.getGroup().getId());
        return studentResponseDto;
    }
}
