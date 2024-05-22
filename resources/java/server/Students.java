import java.rmi.RemoteException;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;

public class Students extends ServerExtension implements StudentInterface 
{
	private int id;
	private String fullName;
	private int age;
	private String address;
	private String contact;

	public Students() throws RemoteException { 
		super(); 
	}

	// Setters
	@Override
	public void setId(int id) throws RemoteException{
		this.id = id;
	}
	@Override
	public void setFullName(String fullName) throws RemoteException{
		this.fullName = fullName;
	}
	@Override
	public void setAge(int age) throws RemoteException{
		this.age = age;
	}
	@Override
	public void setAddress(String address) throws RemoteException{
		this.address = address;
	}
	@Override
    public void setContact(String contact) throws RemoteException{
		this.contact = contact;
	}

	// Getters
	@Override
	public int getId() throws RemoteException{
		return this.id;
	}
	@Override
	public String getFullName() throws RemoteException{
		return this.fullName;
	}
	@Override
	public int getAge() throws RemoteException{
		return this.age;
	}
	@Override
	public String getAddress() throws RemoteException{
		return this.address;
	}
	@Override
    public String getContact() throws RemoteException{
		return this.contact;
	}

	// Misc
	@Override
	public void displayStudent(String message) throws RemoteException
    {
		System.out.println("Client response: " + message);

		// To run alongside display
		insertStudent(Server.connection);
	}
	@Override
	public void triggerTable() throws RemoteException
	{
		studentTable(Server.connection);
	}
	
	public void insertStudent(Connection connection) throws RemoteException
	{
		try
		{
			String sql = studentRow();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, fullName);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, contact);
			preparedStatement.executeUpdate();
			preparedStatement.close();

			System.out.println( "Data inserted to the table");
		}catch (SQLException e) { System.out.println("Insert error: " + e); }
	}
}
