package spring.task.university.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class GroupResponseDto {
    private Long id;
    private String name;
    private List<Long> studentIds;
    private List<Long> dailyScheduleIds;
}
