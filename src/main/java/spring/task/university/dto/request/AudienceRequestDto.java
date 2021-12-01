package spring.task.university.dto.request;

import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class AudienceRequestDto {
    @Positive
    private int number;
    @Positive
    private int capacity;
}
