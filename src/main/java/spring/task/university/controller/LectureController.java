package spring.task.university.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.task.university.dto.request.LectureRequestDto;
import spring.task.university.dto.response.LectureResponseDto;
import spring.task.university.service.LectureService;
import spring.task.university.service.mapper.LectureMapper;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    private final LectureService lectureService;
    private final LectureMapper lectureMapper;

    public LectureController(LectureService lectureService,
                             LectureMapper lectureMapper) {
        this.lectureService = lectureService;
        this.lectureMapper = lectureMapper;
    }

    @PostMapping
    public LectureResponseDto add(@RequestBody @Valid LectureRequestDto lectureRequestDto) {
        return lectureMapper.mapToDto(lectureService.save(
                lectureMapper.mapToModel(lectureRequestDto)));
    }

    @GetMapping
    public List<LectureResponseDto> getAll() {
        return lectureService.findAll()
                .stream()
                .map(lectureMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
