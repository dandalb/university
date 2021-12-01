package spring.task.university.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spring.task.university.dto.request.LectureRequestDto;
import spring.task.university.dto.response.LectureResponseDto;
import spring.task.university.model.Audience;
import spring.task.university.model.Lecture;
import spring.task.university.service.AudienceService;

class LectureMapperTest {
    private static Lecture lecture;
    private static LectureRequestDto lectureRequestDto;
    private static LectureResponseDto lectureResponseDto;
    private static AudienceService audienceService;
    private static Audience audience;
    private LectureMapper lectureMapper;

    @BeforeAll
    static void beforeAll() {
        audience = new Audience();
        audience.setId(1L);

        lecture = new Lecture();
        lecture.setName("History");
        lecture.setAudience(audience);

        lectureRequestDto = new LectureRequestDto();
        lectureRequestDto.setName(lecture.getName());
        lectureRequestDto.setAudienceId(1L);

        lectureResponseDto = new LectureResponseDto();
        lectureResponseDto.setId(1L);
        lectureResponseDto.setAudienceId(1L);
        lectureResponseDto.setName(lecture.getName());
    }

    @BeforeEach
    void setUp() {
        audienceService = Mockito.mock(AudienceService.class);
        lectureMapper = new LectureMapper(audienceService);
    }

    @Test
    void mapToDto_Ok() {
        lecture.setId(1L);
        LectureResponseDto actual = lectureMapper.mapToDto(lecture);
        Assertions.assertEquals(lectureResponseDto, actual);
    }


    @Test
    void mapToModel_Ok() {
        Mockito.when(audienceService.get(lectureRequestDto.getAudienceId())).thenReturn(audience);
        Lecture actual = lectureMapper.mapToModel(lectureRequestDto);
        Assertions.assertEquals(lecture, actual);
    }
}