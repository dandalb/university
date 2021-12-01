package spring.task.university.service;

import spring.task.university.model.DailySchedule;

public interface DailyScheduleService {
    DailySchedule get(Long id);

    DailySchedule save(DailySchedule dailySchedule);

    void delete(DailySchedule dailySchedule);
}
