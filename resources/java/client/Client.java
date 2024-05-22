import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Check the XML file paths
            String studentXML = "C:/xampp/htdocs/finals-106/resources/java/client/students.xml";
            String coursesXML = "C:/xampp/htdocs/finals-106/resources/java/client/courses.xml";

            // IS-A Inheritance
            XMLParser parser = new XMLParser();

            StudentInterface stubStudent = (StudentInterface) registry.lookup("student");
            CourseInterface stubCourse = (CourseInterface) registry.lookup("course");

            // Calls the triggerTable to recreate the table everytime
            // a new data is submitted
            stubStudent.triggerTable();
            stubCourse.triggerTable();

            parser.parseStudents(studentXML, stubStudent);
            parser.parseCourses(coursesXML, stubCourse);

            System.out.print("\033\143");

			
            System.out.println("Data exported successfully");

        } catch (Exception e) {
            System.out.println("Client side error >>> ");
            e.printStackTrace(); // Provide more detailed error info
			System.out.print("\n");
        }
    }
}
