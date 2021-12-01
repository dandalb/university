package spring.task.university.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.task.university.dto.request.AudienceRequestDto;
import spring.task.university.dto.response.AudienceResponseDto;
import spring.task.university.service.AudienceService;
import spring.task.university.service.mapper.AudienceMapper;

@RestController
@RequestMapping("/audiences")
public class AudienceController {
    private final AudienceService audienceService;
    private final AudienceMapper audienceMapper;

    public AudienceController(AudienceService audienceService, AudienceMapper audienceMapper) {
        this.audienceService = audienceService;
        this.audienceMapper = audienceMapper;
    }

    @GetMapping
    public List<AudienceResponseDto> getAll() {
        return audienceService.findAll()
                .stream()
                .map(audienceMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AudienceResponseDto add(@RequestBody @Valid AudienceRequestDto audienceRequestDto) {
        return audienceMapper.mapToDto(audienceService.save(
                audienceMapper.mapToModel(audienceRequestDto)));
    }
}
