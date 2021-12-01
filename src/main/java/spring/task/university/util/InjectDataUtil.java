package spring.task.university.util;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import spring.task.university.model.Audience;
import spring.task.university.model.DailySchedule;
import spring.task.university.model.Group;
import spring.task.university.model.Lecture;
import spring.task.university.model.Student;
import spring.task.university.service.AudienceService;
import spring.task.university.service.DailyScheduleService;
import spring.task.university.service.GroupService;
import spring.task.university.service.LectureService;
import spring.task.university.service.StudentService;

@Component
public class InjectDataUtil {
    private final AudienceService audienceService;
    private final LectureService lectureService;
    private final DailyScheduleService dailyScheduleService;
    private final GroupService groupService;
    private final StudentService studentService;

    public InjectDataUtil(AudienceService audienceService,
                          LectureService lectureService,
                          DailyScheduleService dailyScheduleService,
                          GroupService groupService,
                          StudentService studentService) {
        this.audienceService = audienceService;
        this.lectureService = lectureService;
        this.dailyScheduleService = dailyScheduleService;
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @PostConstruct
    public void injectMockData() {
        Audience audience = new Audience();
        audience.setNumber(1);
        audience.setCapacity(100);
        audienceService.save(audience);

        Lecture lecture = new Lecture();
        lecture.setAudience(audience);
        lecture.setName("History");
        lectureService.save(lecture);

        DailySchedule dailySchedule = new DailySchedule();
        List<Lecture> lectures = new ArrayList<>();
        lectures.add(lecture);
        dailySchedule.setLectures(lectures);
        dailySchedule.setDate(DayOfWeek.MONDAY);
        dailyScheduleService.save(dailySchedule);

        Group group = new Group();
        group.setName("AT-171");
        groupService.save(group);
        List<DailySchedule> dailySchedules = new ArrayList<>();
        dailySchedules.add(dailySchedule);
        group.setDailySchedules(dailySchedules);
        groupService.update(group);

        Student student = new Student();
        student.setName("Pavel");
        student.setLastName("Ivanov");
        student.setGroup(group);
        studentService.save(student);
    }
}
