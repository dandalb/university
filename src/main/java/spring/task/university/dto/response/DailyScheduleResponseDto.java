package spring.task.university.dto.response;

import java.time.DayOfWeek;
import java.util.List;
import lombok.Data;

@Data
public class DailyScheduleResponseDto {
    private Long id;
    private List<Long> lecturesIds;
    private DayOfWeek date;
}
