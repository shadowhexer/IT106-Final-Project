import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServerExtension 
{
    public static void studentTable(Connection connection)
	{
		try
		{
			String studentCreate = "DROP TABLE IF EXISTS students CASCADE;\n" + 
			"CREATE TABLE IF NOT EXISTS students\n" +
				"(\n" +
				"    id int PRIMARY KEY NOT NULL,\n" + 
				"    name character varying(50) NOT NULL,\n" +
				"    age int NOT NULL,\n" +
				"    address varchar (100) NOT NULL,\n" +
				"    contact varchar(20) NOT NULL\n" +
				");"; // HAS-A Inheritance from ServerExtension class
				
			// Create statement for Student table
			PreparedStatement studentPrepStatement = connection.prepareStatement(studentCreate);
			studentPrepStatement.executeUpdate();
			studentPrepStatement.close();
	}catch(SQLException e) { System.out.println("Create error: " + e); }
	}

	public static void courseTable(Connection connection)
	{
		try
		{
			String courseCreate = "DROP TABLE IF EXISTS courses CASCADE;\n" + 
			"CREATE TABLE IF NOT EXISTS courses\n" +
				"(\n" +
				"    id int PRIMARY KEY NOT NULL,\n" + 
				"    student_id int NOT NULL,\n" +
				"    title character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
				"    description varchar (100) NOT NULL,\n" +
				"    FOREIGN KEY (student_id) REFERENCES students (id)\n" + 
				"	 ON UPDATE CASCADE ON DELETE CASCADE\n" +
				");"; // HAS-A Inheritance from ServerExtension class

			// Create statement for Course table
			PreparedStatement coursePrepStatement = connection.prepareStatement(courseCreate);
			coursePrepStatement.executeUpdate();
			coursePrepStatement.close();
			
		}catch(SQLException e) { System.out.println("Create error: " + e); }

	}
	public static String studentRow(){
		return "INSERT INTO students(id, name, age, address, contact) VALUES (?, ?, ?, ?, ?)";
	}
	public static String courseRow(){
		return "INSERT INTO courses(id, student_id, title, description) VALUES (?, ?, ?, ?)";
	}
}
