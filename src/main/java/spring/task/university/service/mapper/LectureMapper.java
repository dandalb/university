package spring.task.university.service.mapper;

import org.springframework.stereotype.Component;
import spring.task.university.dto.request.LectureRequestDto;
import spring.task.university.dto.response.LectureResponseDto;
import spring.task.university.model.Lecture;
import spring.task.university.service.AudienceService;

@Component
public class LectureMapper implements RequestDtoMapper<Lecture, LectureRequestDto>,
        ResponseDtoMapper<LectureResponseDto, Lecture> {
    private final AudienceService audienceService;

    public LectureMapper(AudienceService audienceService) {
        this.audienceService = audienceService;
    }

    @Override
    public Lecture mapToModel(LectureRequestDto dto) {
        Lecture lecture = new Lecture();
        lecture.setName(dto.getName());
        lecture.setAudience(audienceService.get(dto.getAudienceId()));
        return lecture;
    }

    @Override
    public LectureResponseDto mapToDto(Lecture lecture) {
        LectureResponseDto lectureResponseDto = new LectureResponseDto();
        lectureResponseDto.setId(lecture.getId());
        lectureResponseDto.setName(lecture.getName());
        lectureResponseDto.setAudienceId(lecture.getAudience().getId());
        return lectureResponseDto;
    }
}
