package spring.task.university.dto.request;

import java.time.DayOfWeek;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DailyScheduleRequestDto {
    @NotNull
    private List<Long> lecturesIds;
    @NotNull
    private DayOfWeek date;
}
