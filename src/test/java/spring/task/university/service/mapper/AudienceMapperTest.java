package spring.task.university.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spring.task.university.dto.request.AudienceRequestDto;
import spring.task.university.dto.response.AudienceResponseDto;
import spring.task.university.model.Audience;

class AudienceMapperTest {
    private static AudienceMapper audienceMapper;
    private static Audience audience;
    private static AudienceRequestDto audienceRequestDto;
    private static AudienceResponseDto audienceResponseDto;

    @BeforeAll
    static void beforeAll() {
        audienceMapper = new AudienceMapper();
        audience = new Audience();
        audience.setNumber(2);
        audience.setCapacity(100);

        audienceRequestDto = new AudienceRequestDto();
        audienceRequestDto.setCapacity(audience.getCapacity());
        audienceRequestDto.setNumber(audience.getNumber());

        audienceResponseDto = new AudienceResponseDto();
        audienceResponseDto.setId(1L);
        audienceResponseDto.setNumber(audience.getNumber());
        audienceResponseDto.setCapacity(audience.getCapacity());
    }

    @Test
    void mapToDto_Ok() {
        audience.setId(1L);
        AudienceResponseDto actual = audienceMapper.mapToDto(audience);
        Assertions.assertEquals(audienceResponseDto, actual);
    }


    @Test
    void mapToModel_Ok() {
        Audience actual = audienceMapper.mapToModel(audienceRequestDto);
        Assertions.assertEquals(audience, actual);
    }
}