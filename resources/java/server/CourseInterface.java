import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CourseInterface extends Remote{
	// Lets us define API

	public void setCourseCode(int courseCode) throws RemoteException;
	public void setStudentID(int studentID) throws RemoteException;
	public void setCourseTitle(String courseTitle) throws RemoteException;
	public void setCourseDescription(String courseDescription) throws RemoteException;

	public int getCourseCode() throws RemoteException;
	public int getStudentID() throws RemoteException;
	public String getCourseTitle() throws RemoteException;
	public String getCourseDescription() throws RemoteException;

	public void triggerTable() throws RemoteException;
	public void displayCourse() throws RemoteException;
}