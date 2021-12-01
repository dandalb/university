package spring.task.university.controller;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.task.university.dto.request.DailyScheduleRequestDto;
import spring.task.university.dto.response.DailyScheduleResponseDto;
import spring.task.university.service.DailyScheduleService;
import spring.task.university.service.StudentService;
import spring.task.university.service.mapper.DailyScheduleMapper;

@RestController
@RequestMapping("/daily-schedules")
public class DailyScheduleController {
    private final DailyScheduleService dailyScheduleService;
    private final DailyScheduleMapper dailyScheduleMapper;
    private final StudentService studentService;

    public DailyScheduleController(DailyScheduleService dailyScheduleService,
                                   DailyScheduleMapper dailyScheduleMapper,
                                   StudentService studentService) {
        this.dailyScheduleService = dailyScheduleService;
        this.dailyScheduleMapper = dailyScheduleMapper;
        this.studentService = studentService;
    }

    @PostMapping
    public DailyScheduleResponseDto add(
            @RequestBody @Valid DailyScheduleRequestDto dailyScheduleRequestDto) {
        return dailyScheduleMapper.mapToDto(dailyScheduleService.save(
                dailyScheduleMapper.mapToModel(dailyScheduleRequestDto)));
    }

    @GetMapping("/by-student")
    public List<DailyScheduleResponseDto> getByStudent(@RequestParam Long studentId,
                                                       @RequestParam DayOfWeek day) {
        return studentService.get(studentId).getGroup().getDailySchedules()
                .stream()
                .filter(d -> d.getDate().equals(day))
                .map(dailyScheduleMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
