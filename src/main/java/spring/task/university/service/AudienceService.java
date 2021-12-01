package spring.task.university.service;

import java.util.List;
import spring.task.university.model.Audience;

public interface AudienceService {
    Audience get(Long id);

    Audience save(Audience audience);

    void delete(Audience audience);

    List<Audience> findAll();

}
