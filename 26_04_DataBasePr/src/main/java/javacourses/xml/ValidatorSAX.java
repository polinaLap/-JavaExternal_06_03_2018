package javacourses.xml;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {
    final static Logger logger = Logger.getLogger(ValidatorSAX.class);
    public static void isValid(String filename, String schemaname){
        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try{
            schema = factory.newSchema(new File(schemaname));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(filename,new LessonErrorHandler());
            logger.info(filename+" is valid");
        } catch (SAXException e) {
            logger.error(e.getMessage());
        } catch (ParserConfigurationException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private static class LessonErrorHandler extends DefaultHandler {

        public void warning(SAXParseException e){
            logger.warn(e.getColumnNumber()+" "+ e.getMessage());
        }
        public void error(SAXParseException e){
            logger.error(e.getColumnNumber()+" "+e.getMessage());
        }
        public void fatalError(SAXParseException e){
            logger.fatal(e.getColumnNumber()+" "+e.getMessage());
        }

    }
}
