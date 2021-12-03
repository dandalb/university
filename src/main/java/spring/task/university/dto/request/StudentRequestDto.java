package spring.task.university.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class StudentRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @Positive
    private Long groupId;
}
