package javacourses.entities;

public class Shedule {
    private int lessonId;
    private int dayId;

    public Shedule(int lessonId, int dayId) {
        this.lessonId = lessonId;
        this.dayId = dayId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }
}
