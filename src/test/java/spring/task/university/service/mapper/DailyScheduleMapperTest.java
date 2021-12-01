package spring.task.university.service.mapper;

import java.time.DayOfWeek;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spring.task.university.dto.request.DailyScheduleRequestDto;
import spring.task.university.dto.response.DailyScheduleResponseDto;
import spring.task.university.model.DailySchedule;
import spring.task.university.model.Lecture;
import spring.task.university.service.LectureService;

class DailyScheduleMapperTest {
    private static DailySchedule dailySchedule;
    private static DailyScheduleRequestDto dailyScheduleRequestDto;
    private static DailyScheduleResponseDto dailyScheduleResponseDto;
    private static Lecture lecture;
    private LectureService lectureService;
    private DailyScheduleMapper dailyScheduleMapper;

    @BeforeAll
    static void beforeAll() {
        lecture = new Lecture();
        lecture.setId(1L);

        dailySchedule = new DailySchedule();
        dailySchedule.setDate(DayOfWeek.MONDAY);
        dailySchedule.setLectures(List.of(lecture));

        dailyScheduleResponseDto = new DailyScheduleResponseDto();
        dailyScheduleResponseDto.setId(1L);
        dailyScheduleResponseDto.setDate(dailySchedule.getDate());
        dailyScheduleResponseDto.setLecturesIds(List.of(lecture.getId()));

        dailyScheduleRequestDto = new DailyScheduleRequestDto();
        dailyScheduleRequestDto.setDate(dailySchedule.getDate());
        dailyScheduleRequestDto.setLecturesIds(List.of(lecture.getId()));
    }

    @BeforeEach
    void setUp() {
        lectureService = Mockito.mock(LectureService.class);
        dailyScheduleMapper = new DailyScheduleMapper(lectureService);
    }

    @Test
    void mapToDto() {
        dailySchedule.setId(1L);
        DailyScheduleResponseDto actual = dailyScheduleMapper.mapToDto(dailySchedule);
        Assertions.assertEquals(dailyScheduleResponseDto, actual);
    }

    @Test
    void mapToModel() {
        Mockito.when(lectureService.get(dailyScheduleRequestDto.getLecturesIds().get(0)))
                .thenReturn(lecture);
        DailySchedule actual = dailyScheduleMapper.mapToModel(dailyScheduleRequestDto);
        Assertions.assertEquals(dailySchedule, actual);
    }
}