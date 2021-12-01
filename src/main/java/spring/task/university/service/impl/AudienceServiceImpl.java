package spring.task.university.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.task.university.model.Audience;
import spring.task.university.repository.AudienceRepository;
import spring.task.university.service.AudienceService;

@Service
public class AudienceServiceImpl implements AudienceService {
    private final AudienceRepository audienceRepository;

    public AudienceServiceImpl(AudienceRepository audienceRepository) {
        this.audienceRepository = audienceRepository;
    }

    @Override
    public Audience get(Long id) {
        return audienceRepository.getById(id);
    }

    @Override
    public Audience save(Audience audience) {
        return audienceRepository.save(audience);
    }

    @Override
    public void delete(Audience audience) {
        audienceRepository.delete(audience);
    }

    @Override
    public List<Audience> findAll() {
        return audienceRepository.findAll();
    }
}
