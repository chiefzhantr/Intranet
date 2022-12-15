package Main;

import java.util.Date;

public class Lesson {
    private LessonType lessonType;
    private Date dayAndTime;

    public Lesson(LessonType lessonType, Date dayAndTime) {
        this.lessonType = lessonType;
        this.dayAndTime = dayAndTime;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public Date getDayAndTime() {
        return dayAndTime;
    }

    public void setDayAndTime(Date dayAndTime) {
        this.dayAndTime = dayAndTime;
    }
}
