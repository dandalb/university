package spring.task.university.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.task.university.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Query("select l from Lecture l left join fetch l.audience where l.id = :lectureId")
    Lecture getById(@Param(value = "lectureId") Long lectureId);

    @Query("select l from Lecture l left join fetch l.audience")
    List<Lecture> findAll();
}
