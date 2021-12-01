package spring.task.university.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spring.task.university.model.Audience;
import spring.task.university.repository.AudienceRepository;
import spring.task.university.service.impl.AudienceServiceImpl;

class AudienceServiceTest {
    private AudienceService audienceService;
    private AudienceRepository audienceRepository;
    private static Audience audience;
    private static List<Audience> audienceList;

    @BeforeAll
    static void beforeAll() {
        audience = new Audience();
        audience.setId(1L);
        audience.setCapacity(100);
        audience.setNumber(1);
        audienceList = new ArrayList<>();
        audienceList.add(audience);
    }

    @BeforeEach
    void setUp() {
        audienceRepository = Mockito.mock(AudienceRepository.class);
        audienceService = new AudienceServiceImpl(audienceRepository);
    }

    @Test
    void save_Ok() {
        Mockito.when(audienceRepository.save(audience)).thenReturn(audience);
        Audience actual = audienceService.save(audience);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(audience, actual);
    }

    @Test
    void get_Ok() {
        Mockito.when(audienceRepository.getById(1L)).thenReturn(audience);
        Audience actual = audienceService.get(1L);
        Assertions.assertEquals(audience, actual);

    }

    @Test
    void findAll_Ok() {
        Mockito.when(audienceRepository.findAll()).thenReturn(audienceList);
        List<Audience> actualList = audienceService.findAll();
        Assertions.assertEquals(1, actualList.size());
        Assertions.assertEquals(audience, actualList.get(0));
    }
}