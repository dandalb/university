package spring.task.university.service.mapper;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spring.task.university.dto.request.GroupRequestDto;
import spring.task.university.dto.response.GroupResponseDto;
import spring.task.university.model.DailySchedule;
import spring.task.university.model.Group;
import spring.task.university.model.Student;

class GroupMapperTest {
    private static GroupMapper groupMapper;
    private static Group group;
    private static GroupResponseDto groupResponseDto;
    private static GroupRequestDto groupRequestDto;
    private static Student student;
    private static DailySchedule dailySchedule;

    @BeforeAll
    static void beforeAll() {
        groupMapper = new GroupMapper();
        student = new Student();
        student.setId(1L);
        dailySchedule = new DailySchedule();
        dailySchedule.setId(1L);

        group = new Group();
        group.setName("AT-171");

        groupResponseDto = new GroupResponseDto();
        groupResponseDto.setName(group.getName());
        groupResponseDto.setStudentIds(List.of(student.getId()));
        groupResponseDto.setDailyScheduleIds(List.of(dailySchedule.getId()));

        groupRequestDto = new GroupRequestDto();
        groupRequestDto.setName(group.getName());
    }

    @Test
    void mapToModel() {
        Group actual = groupMapper.mapToModel(groupRequestDto);
        Assertions.assertEquals(group, actual);
    }

    @Test
    void mapToDto() {
        group.setStudents(List.of(student));
        group.setDailySchedules(List.of(dailySchedule));
        GroupResponseDto actual = groupMapper.mapToDto(group);
        Assertions.assertEquals(groupResponseDto, actual);
    }
}