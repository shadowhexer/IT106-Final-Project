import java.rmi.RemoteException;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;

public class Courses extends ServerExtension implements CourseInterface
{
	// Attributes of product
	private int courseCode;
	private int studentID;
	private String courseDescription;
	private String courseTitle;

	public Courses() throws RemoteException {
        super();
    }

	// Setters
	@Override
	public void setCourseCode(int courseCode) throws RemoteException{
		this.courseCode = courseCode;
	}
	@Override
	public void setStudentID(int studentID) throws RemoteException{
		this.studentID = studentID;
	}
	@Override
	public void setCourseTitle(String courseTitle) throws RemoteException{
		this.courseTitle = courseTitle;
	}
	@Override
	public void setCourseDescription(String courseDescription) throws RemoteException{
		this.courseDescription = courseDescription;
	}

	// Getters
	@Override
	public int getCourseCode() throws RemoteException{
		return this.courseCode;
	}
	@Override
	public int getStudentID() throws RemoteException{
		return this.studentID;
	}
	@Override
	public String getCourseTitle() throws RemoteException{
		return this.courseTitle;
	}
	@Override
	public String getCourseDescription() throws RemoteException{
		return this.courseDescription;
	}

	// Misc
	@Override
	public void triggerTable() throws RemoteException
	{
		courseTable(Server.connection);
	}
	@Override
	public void displayCourse() throws RemoteException
    {
		System.out.println( "Server Reponse: A Client has submit new data");

		//To run alongside display
		insertCourse(Server.connection);
	}
	public void insertCourse(Connection connection) throws RemoteException
	{
		try
		{
			String sql = courseRow();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, courseCode);
			preparedStatement.setInt(2, studentID);
			preparedStatement.setString(3, courseTitle);
			preparedStatement.setString(4, courseDescription);
			preparedStatement.executeUpdate();
			preparedStatement.close();

			System.out.println( "Query response: Data inserted to the table");
		}catch (SQLException e) { System.out.println("Query error: " + e); }
	}
}
