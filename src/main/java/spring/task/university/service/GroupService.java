package spring.task.university.service;

import java.util.List;
import spring.task.university.model.DailySchedule;
import spring.task.university.model.Group;
import spring.task.university.model.Student;

public interface GroupService {
    Group get(Long id);

    Group save(Group group);

    void delete(Group group);

    List<Group> findAll();

    Group update(Group group);

    Group addDailySchedule(Group group, DailySchedule dailySchedule);

    Group addStudent(Group group, Student student);
}
