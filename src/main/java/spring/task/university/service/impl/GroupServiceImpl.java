package spring.task.university.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import spring.task.university.model.DailySchedule;
import spring.task.university.model.Group;
import spring.task.university.model.Student;
import spring.task.university.repository.GroupRepository;
import spring.task.university.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group get(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public Group save(Group group) {
        group.setDailySchedules(new ArrayList<>());
        group.setStudents(new ArrayList<>());
        return groupRepository.save(group);
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group addDailySchedule(Group group, DailySchedule dailySchedule) {
        group.getDailySchedules().add(dailySchedule);
        return groupRepository.save(group);
    }

    @Override
    public Group addStudent(Group group, Student student) {
        group.getStudents().add(student);
        return groupRepository.save(group);
    }
}
