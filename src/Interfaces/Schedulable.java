package Interfaces;

import Main.Schedule;

public interface Schedulable {
    Schedule getSchedule();

    void viewSchedule();

    void viewLessonSchedule();

    void viewExamSchedule();
}
