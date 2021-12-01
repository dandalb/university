package spring.task.university.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.task.university.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("select g from Group g "
            + "left join fetch g.students "
            + "where g.id = :groupId")
    Group getById(@Param(value = "groupId") Long groupId);

    @Query("select g from Group g left join fetch g.students")
    List<Group> findAll();
}
