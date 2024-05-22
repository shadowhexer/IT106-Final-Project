import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server
{
    static Connection connection = null;

    public static void main(String[] args) {

		System.setProperty("java.rmi.server.hostname", "127.0.0.1");

        try 
		{
			Registry registry = LocateRegistry.createRegistry(9100);
			// Only one registry per server
			//run "java -classpath postgresql-42.7.3.jar; Server"
            try
            {
				String jdbcUrl = "jdbc:postgresql://localhost:5432/php";
				String username = "postgres";
				String password = "chelsea0710";

				try
				{
					Class.forName("org.postgresql.Driver");
					connection = DriverManager.getConnection(jdbcUrl, username, password);

                    // Initialise Student
					Students student = new Students();
                    StudentInterface stubStudent = (StudentInterface) UnicastRemoteObject.exportObject(student, 0);
                	registry.rebind("student", stubStudent);

                    // Initialise Course
					Courses course = new Courses();
                    CourseInterface stubCourse = (CourseInterface) UnicastRemoteObject.exportObject(course, 0);
                	registry.rebind("course", stubCourse);

                    System.out.print("\033\143");
					System.out.println("\nServer initialised....");
				}
				catch (ClassNotFoundException e) { System.out.println("Driver error: " + e); }
                
            }catch(SQLException e) { System.out.println("Connection error: " + e);	}

        }catch (RemoteException e) {
            System.out.print("Server error >>> ");
            e.printStackTrace(); // Provide more detailed error info
			System.out.print("\n");
        }
    }
}