
package libro.cap12.framework;

import java.sql.Connection;

public class XTransaction
{
	private Connection connection;
	
	public Connection getConnection()
	{
		return connection;
	}

	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}

	public void commint()
	{
		try
		{
			connection.commit();
			XConnectionPool pool =XFactory.getInstancia().getConnectionPool();
			pool.releaseConnectionForTransaction(connection);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public void rollback()
	{
		try
		{
			connection.rollback();
			XConnectionPool pool =XFactory.getInstancia().getConnectionPool();
			pool.releaseConnectionForTransaction(connection);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}		
	}
}
