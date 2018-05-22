package javacourses.containers;

import javacourses.entities.Lesson;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Lessons {
    @XmlElement(name = "lesson")
    List<Lesson> lessons = new ArrayList<Lesson>();

    public Lessons(){};
    public void setList(List<Lesson> list){
        this.lessons=list;
    }
    public boolean add(Lesson l){
        return lessons.add(l);
    }

    @Override
    public String toString() {
        return
                "Lessons:\n" + lessons;
    }
}
