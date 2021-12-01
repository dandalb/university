package spring.task.university.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import spring.task.university.dto.request.DailyScheduleRequestDto;
import spring.task.university.dto.response.DailyScheduleResponseDto;
import spring.task.university.model.DailySchedule;
import spring.task.university.model.Lecture;
import spring.task.university.service.LectureService;

@Component
public class DailyScheduleMapper implements
        ResponseDtoMapper<DailyScheduleResponseDto, DailySchedule>,
        RequestDtoMapper<DailySchedule, DailyScheduleRequestDto> {
    private final LectureService lectureService;

    public DailyScheduleMapper(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Override
    public DailyScheduleResponseDto mapToDto(DailySchedule dailySchedule) {
        DailyScheduleResponseDto dailyScheduleResponseDto =
                new DailyScheduleResponseDto();
        dailyScheduleResponseDto.setId(dailySchedule.getId());
        dailyScheduleResponseDto.setDate(dailySchedule.getDate());
        dailyScheduleResponseDto.setLecturesIds(dailySchedule.getLectures()
                .stream()
                .map(Lecture::getId)
                .collect(Collectors.toList()));
        return dailyScheduleResponseDto;
    }

    @Override
    public DailySchedule mapToModel(DailyScheduleRequestDto dto) {
        DailySchedule dailySchedule = new DailySchedule();
        dailySchedule.setDate(dto.getDate());
        dailySchedule.setLectures(dto.getLecturesIds()
                .stream()
                .map(lectureService::get)
                .collect(Collectors.toList()));
        return dailySchedule;
    }
}
