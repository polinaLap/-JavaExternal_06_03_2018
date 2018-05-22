package javacourses.entities;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Lesson",propOrder = {"id","name"})
public class Lesson {
    @XmlElement(required = true)
    private int id;
    @XmlElement(required = true)
    private String name;

    public Lesson(){}
    public Lesson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

