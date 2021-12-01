package spring.task.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.task.university.model.DailySchedule;

public interface DailyScheduleRepository extends
        JpaRepository<DailySchedule, Long> {
    @Query("select ds from DailySchedule ds "
            + "left join fetch ds.lectures l "
            + "where ds.id = :dailyScheduleId")
    DailySchedule getById(@Param(value = "dailyScheduleId") Long dailyScheduleId);
}
