package spring.task.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.task.university.model.Audience;

public interface AudienceRepository extends JpaRepository<Audience, Long> {

}
