package spring.task.university.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.task.university.dto.request.GroupRequestDto;
import spring.task.university.dto.response.GroupResponseDto;
import spring.task.university.service.DailyScheduleService;
import spring.task.university.service.GroupService;
import spring.task.university.service.mapper.GroupMapper;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;
    private final DailyScheduleService dailyScheduleService;

    public GroupController(GroupService groupService,
                           GroupMapper groupMapper,
                           DailyScheduleService dailyScheduleService) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
        this.dailyScheduleService = dailyScheduleService;
    }

    @PostMapping
    public GroupResponseDto add(@RequestBody @Valid GroupRequestDto groupRequestDto) {
        return groupMapper.mapToDto(groupService.save(groupMapper.mapToModel(groupRequestDto)));
    }

    @PutMapping("/daily-schedule")
    public void addDailySchedule(@RequestParam Long groupId,
                                 @RequestParam Long dailyScheduleId) {
        groupService.addDailySchedule(groupService.get(groupId),
                dailyScheduleService.get(dailyScheduleId));
    }

    @GetMapping
    public List<GroupResponseDto> getAll() {
        return groupService.findAll()
                .stream()
                .map(groupMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
