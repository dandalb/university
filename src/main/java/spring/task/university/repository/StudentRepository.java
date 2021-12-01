package spring.task.university.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.task.university.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s "
            + "left join fetch s.group g "
            + "where s.id =:studentId")
    Student getById(@Param(value = "studentId") Long studentId);

    @Query("select s from Student s left join fetch s.group g")
    List<Student> findAll();
}
