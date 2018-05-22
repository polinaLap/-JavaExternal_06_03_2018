package javacourses;

import javacourses.xml.ValidatorSAX;


public class App
{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       /* WeekDayDAO wddao = new WeekDayDAO();
        WeekDay wd = wddao.getWeekDayById(2);
        System.out.println(wd.getName());
       LessonDAO lsdao = new LessonDAO();
       Lesson ls = lsdao.getLessonById(1);
        System.out.println(ls.getName());

        lsdao.addLesson("newLesson");*/
       //SheduleDAO shdao = new SheduleDAO();
       /* List<String> l = shdao.getShedule();
       for (String s:l) {
           System.out.println(s);
       }
        System.out.println(shdao.getDaysByLesson("Mathematic"));
        System.out.println(shdao.getLessonsByDay("Monday"));*/
        //System.out.println(shdao.addLessonAndReturnMessage(new WeekDay(2,"Tuesday"),new Lesson(3,"English")));
       // List<Shedule> linesToRemove = new ArrayList<>();
       /* linesToRemove.add(new Shedule(1,1));
        linesToRemove.add(new Shedule(1,3));
        shdao.removeSheduleLines(linesToRemove);*/
        /*Lessons lessons = new Lessons();
        lessons.add(new Lesson(1,"Math"));
        lessons.add(new Lesson(2,"Ukr"));
        lessons.add(new Lesson(3,"Physics"));
        lessons.add(new Lesson(4,"Chemistry"));
        lessons.add(new Lesson(5,"Geography"));
        (new MarshalWrite()).write(lessons);*/
        ValidatorSAX.isValid("lessons.xml","lessons.xsd");

    }
}

