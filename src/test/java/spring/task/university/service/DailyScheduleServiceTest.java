package spring.task.university.service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spring.task.university.model.DailySchedule;
import spring.task.university.repository.DailyScheduleRepository;
import spring.task.university.service.impl.DailyScheduleServiceImpl;

class DailyScheduleServiceTest {
    private static DailySchedule dailySchedule;
    private DailyScheduleService dailyScheduleService;
    private DailyScheduleRepository dailyScheduleRepository;

    @BeforeAll
    static void beforeAll() {
        dailySchedule = new DailySchedule();
        dailySchedule.setId(1L);
        dailySchedule.setLectures(new ArrayList<>());
        dailySchedule.setDate(DayOfWeek.MONDAY);
    }

    @BeforeEach
    void setUp() {
        dailyScheduleRepository = Mockito.mock(DailyScheduleRepository.class);
        dailyScheduleService = new DailyScheduleServiceImpl(dailyScheduleRepository);
    }

    @Test
    void get() {
        Mockito.when(dailyScheduleRepository.getById(1L)).thenReturn(dailySchedule);
        DailySchedule actual = dailyScheduleService.get(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(dailySchedule, actual);
    }

    @Test
    void save() {
        Mockito.when(dailyScheduleRepository.save(dailySchedule)).thenReturn(dailySchedule);
        DailySchedule actual = dailyScheduleService.save(dailySchedule);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(dailySchedule, actual);
    }
}