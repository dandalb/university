package spring.task.university.dto.response;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private Long groupId;
}
