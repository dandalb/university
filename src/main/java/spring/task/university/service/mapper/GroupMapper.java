package spring.task.university.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import spring.task.university.dto.request.GroupRequestDto;
import spring.task.university.dto.response.GroupResponseDto;
import spring.task.university.model.DailySchedule;
import spring.task.university.model.Group;
import spring.task.university.model.Student;

@Component
public class GroupMapper implements ResponseDtoMapper<GroupResponseDto, Group>,
        RequestDtoMapper<Group, GroupRequestDto> {

    @Override
    public Group mapToModel(GroupRequestDto dto) {
        Group group = new Group();
        group.setName(dto.getName());
        return group;
    }

    @Override
    public GroupResponseDto mapToDto(Group group) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        groupResponseDto.setId(group.getId());
        groupResponseDto.setName(group.getName());
        groupResponseDto.setStudentIds(group.getStudents()
                .stream()
                .map(Student::getId)
                .collect(Collectors.toList()));
        groupResponseDto.setDailyScheduleIds(group.getDailySchedules()
                .stream()
                .map(DailySchedule::getId)
                .collect(Collectors.toList()));
        return groupResponseDto;
    }
}
