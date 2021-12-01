package spring.task.university.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spring.task.university.dto.request.StudentRequestDto;
import spring.task.university.dto.response.StudentResponseDto;
import spring.task.university.model.Group;
import spring.task.university.model.Student;
import spring.task.university.repository.GroupRepository;
import spring.task.university.service.GroupService;

class StudentMapperTest {
    private static Student student;
    private static Group group;
    private static StudentRequestDto studentRequestDto;
    private static StudentResponseDto studentResponseDto;
    private GroupService groupService;
    private StudentMapper studentMapper;

    @BeforeAll
    static void beforeAll() {
        group = new Group();
        group.setId(1L);

        student = new Student();
        student.setName("Pavlo");
        student.setLastName("Ivanov");
        student.setGroup(group);

        studentRequestDto = new StudentRequestDto();
        studentRequestDto.setName(student.getName());
        studentRequestDto.setLastName(student.getLastName());
        studentRequestDto.setGroupId(group.getId());

        studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(1L);
        studentResponseDto.setName(student.getName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setGroupId(group.getId());
    }

    @BeforeEach
    void setUp() {
        groupService = Mockito.mock(GroupService.class);
        studentMapper = new StudentMapper(groupService);
    }

    @Test
    void mapToModel() {
        Mockito.when(groupService.get(studentRequestDto.getGroupId()))
                .thenReturn(group);
        Student actual = studentMapper.mapToModel(studentRequestDto);
        Assertions.assertEquals(student, actual);
    }

    @Test
    void mapToDto() {
        student.setId(1L);
        StudentResponseDto actual = studentMapper.mapToDto(student);
        Assertions.assertEquals(studentResponseDto, actual);
    }
}