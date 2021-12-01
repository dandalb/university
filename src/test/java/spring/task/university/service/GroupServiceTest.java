package spring.task.university.service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spring.task.university.model.DailySchedule;
import spring.task.university.model.Group;
import spring.task.university.model.Student;
import spring.task.university.repository.GroupRepository;
import spring.task.university.service.impl.GroupServiceImpl;

class GroupServiceTest {
    private static Group group;
    private static List<Group> groupList;
    private static DailySchedule dailySchedule;
    private static Student student;
    private GroupRepository groupRepository;
    private GroupService groupService;

    @BeforeAll
    static void beforeAll() {
        group = new Group();
        group.setId(1L);
        group.setName("AT-171");
        group.setDailySchedules(new ArrayList<>());
        group.setStudents(new ArrayList<>());
        groupList = List.of(group);

        dailySchedule = new DailySchedule();
        dailySchedule.setId(1L);
        dailySchedule.setDate(DayOfWeek.MONDAY);
        dailySchedule.setLectures(new ArrayList<>());

        student = new Student();
        student.setId(1L);
        student.setGroup(group);
        student.setName("Pavlo");
        student.setLastName("Ivanov");
    }

    @BeforeEach
    void setUp() {
        groupRepository = Mockito.mock(GroupRepository.class);
        groupService = new GroupServiceImpl(groupRepository);
    }

    @Test
    void get() {
        Mockito.when(groupRepository.getById(1L)).thenReturn(group);
        Group actual = groupService.get(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(group, actual);
    }

    @Test
    void save() {
        Mockito.when(groupRepository.save(group)).thenReturn(group);
        Group actual = groupService.save(group);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(group, actual);
    }

    @Test
    void findAll() {
        Mockito.when(groupRepository.findAll()).thenReturn(groupList);
        List<Group> actualList = groupService.findAll();
        Assertions.assertEquals(1, actualList.size());
        Assertions.assertEquals(group, actualList.get(0));
    }

    @Test
    void update() {
        Mockito.when(groupRepository.save(group)).thenReturn(group);
        Group actual = groupService.update(group);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(group, actual);
    }

    @Test
    void addDailySchedule() {
        Mockito.when(groupRepository.save(group)).thenReturn(group);
        group.getDailySchedules().add(dailySchedule);
        Group actual = groupService.addDailySchedule(group, dailySchedule);
        Assertions.assertNotNull(actual.getDailySchedules().get(0));
        Assertions.assertEquals(group.getDailySchedules().get(0), dailySchedule);
    }

    @Test
    void addStudent() {
        Mockito.when(groupRepository.save(group)).thenReturn(group);
        group.getStudents().add(student);
        Group actual = groupService.addStudent(GroupServiceTest.group, student);
        Assertions.assertNotNull(actual.getStudents().get(0));
        Assertions.assertEquals(group.getStudents().get(0), student);
    }
}