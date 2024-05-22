import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote{
	// Lets us define API


	public void setId(int id) throws RemoteException;
	public void setFullName(String fullName) throws RemoteException;
	public void setAge(int age) throws RemoteException;
	public void setAddress(String address) throws RemoteException;
    public void setContact(String contact) throws RemoteException;

	public int[] getId() throws RemoteException;
	public String[] getFullName() throws RemoteException;
	public int[] getAge() throws RemoteException;
	public String[] getAddress() throws RemoteException;
    public String[] getContact() throws RemoteException;

	public void triggerTable() throws RemoteException;
	public void displayStudent(String message) throws RemoteException;   
}