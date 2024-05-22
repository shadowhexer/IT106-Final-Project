import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLParser 
{    
    public void parseStudents(String filePath, StudentInterface stubStudent) throws ParserConfigurationException, SAXException, IOException 
    {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("student");

        for (int i = 0; i < nodeList.getLength(); i++) 
        {
            Element element = (Element) nodeList.item(i);
            
            int id = Integer.parseInt(element.getAttribute("id"));
            String fullName = element.getAttribute("name");
            int age = Integer.parseInt(element.getAttribute("age"));
            String address = element.getAttribute("address");
            String contact = element.getAttribute("contact");

            // Register to the stub
            stubStudent.setId(id);
            stubStudent.setFullName(fullName);
            stubStudent.setAge(age);
            stubStudent.setAddress(address);
            stubStudent.setContact(contact);

            stubStudent.displayStudent("A Client has submitted a new data");

            System.out.println("Student ID: " + id);
            System.out.println("Name: " + fullName);
            System.out.println("Age: " + age);
            System.out.println("Address: " + address);
            System.out.println("Contact: " + contact);
            System.out.println("============================");

        }
    }

    public void parseCourses(String filePath, CourseInterface stubCourse) throws ParserConfigurationException, SAXException, IOException 
    {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("course");

        for (int i = 0; i < nodeList.getLength(); i++) 
        {
            Element element = (Element) nodeList.item(i);

            int id = Integer.parseInt(element.getAttribute("id"));
            int studentId = Integer.parseInt(element.getAttribute("student_id"));
            String title = element.getAttribute("title");
            String description = element.getAttribute("description");

            stubCourse.setCourseCode(id);
            stubCourse.setStudentID(studentId);
            stubCourse.setCourseTitle(title);
            stubCourse.setCourseDescription(description);

            stubCourse.displayCourse();

            System.out.println("Course ID: " + id);
            System.out.println("Student ID: " + studentId);
            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println("============================");
        }
    }
}
