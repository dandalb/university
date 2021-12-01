package spring.task.university.service.impl;

import org.springframework.stereotype.Service;
import spring.task.university.model.DailySchedule;
import spring.task.university.repository.DailyScheduleRepository;
import spring.task.university.service.DailyScheduleService;

@Service
public class DailyScheduleServiceImpl implements DailyScheduleService {
    private final DailyScheduleRepository dailyScheduleRepository;

    public DailyScheduleServiceImpl(DailyScheduleRepository dailyScheduleRepository) {
        this.dailyScheduleRepository = dailyScheduleRepository;
    }

    @Override
    public DailySchedule get(Long id) {
        return dailyScheduleRepository.getById(id);
    }

    @Override
    public DailySchedule save(DailySchedule dailySchedule) {
        return dailyScheduleRepository.save(dailySchedule);
    }

    @Override
    public void delete(DailySchedule dailySchedule) {
        dailyScheduleRepository.delete(dailySchedule);
    }
}
