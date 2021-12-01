package spring.task.university.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GroupRequestDto {
    @NotNull
    private String name;
}

