package spring.task.university.service.mapper;

import org.springframework.stereotype.Component;
import spring.task.university.dto.request.AudienceRequestDto;
import spring.task.university.dto.response.AudienceResponseDto;
import spring.task.university.model.Audience;

@Component
public class AudienceMapper implements ResponseDtoMapper<AudienceResponseDto, Audience>,
        RequestDtoMapper<Audience, AudienceRequestDto> {
    @Override
    public Audience mapToModel(AudienceRequestDto dto) {
        Audience audience = new Audience();
        audience.setNumber(dto.getNumber());
        audience.setCapacity(dto.getCapacity());
        return audience;
    }

    @Override
    public AudienceResponseDto mapToDto(Audience audience) {
        AudienceResponseDto audienceResponseDto = new AudienceResponseDto();
        audienceResponseDto.setId(audience.getId());
        audienceResponseDto.setNumber(audience.getNumber());
        audienceResponseDto.setCapacity(audience.getCapacity());
        return audienceResponseDto;
    }
}
