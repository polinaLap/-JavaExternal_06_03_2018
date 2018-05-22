package javacourses.xml;

import javacourses.containers.Lessons;
import org.apache.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MarshalWrite {
    final static Logger logger = Logger.getLogger(MarshalWrite.class);
    public void write(Lessons lessons){
       try{
           JAXBContext context = JAXBContext.newInstance(Lessons.class);
           Marshaller m = context.createMarshaller();
           m.marshal(lessons,new FileOutputStream("lessons.xml"));
       } catch (FileNotFoundException e) {
           logger.error(e.getMessage());
       } catch (JAXBException e) {
          logger.error(e.getMessage());
       }
    }
}
