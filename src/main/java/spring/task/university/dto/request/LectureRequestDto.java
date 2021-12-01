package spring.task.university.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class LectureRequestDto {
    @NotNull
    private String name;
    @Positive
    private Long audienceId;
}
