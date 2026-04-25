
package libro.cap12.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Hashtable;
import java.util.Vector;

import libro.cap12.framework.xml.XMLFactory;
import libro.cap12.framework.xml.XTag;


public class XConnectionPool
{
	private Vector<Connection> libres;
	private Vector<Connection> usadas;
	private Hashtable<Long, Connection> enTransaccion;

	private String url;
	private String driver;
	private String usr;
	private String pwd;

	private int minsize;
	private int maxsize;
	private int steep;

	XConnectionPool()
	{
		try
		{
			//ConnectionPoolTAG tag = XMLHandler.getFrameworkTAG().getDataAccess().getConnectionPoolTAG();
			XTag tag = XMLFactory.getByPath("/framework/data-access/connection-pool");
			
			
			// obtengo los parametros de la conexion
			url = tag.getAtts().get("url");
			driver = tag.getAtts().get("driver");
			usr = tag.getAtts().get("usr");
			pwd = tag.getAtts().get("pwd");

			// levanto el driver
			Class.forName(driver);

			// obtengo los parametros del pool
			minsize = Integer.parseInt(tag.getAtts().get("minsize"));
			maxsize = Integer.parseInt(tag.getAtts().get("maxsize"));
			steep = Integer.parseInt(tag.getAtts().get("steep"));

			libres = new Vector<Connection>();
			usadas = new Vector<Connection>();
			enTransaccion = new Hashtable<Long, Connection>();

			// instancio las primeras n conexiones
			_instanciar(minsize);
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public String toString()
	{
		return "libres: " + libres.size() + ", usadas: " + usadas.size();
	}
	
	Connection getConnectionForTransaction()
	{
		Connection con = getConnection();
		long threadID = Thread.currentThread().getId();
		enTransaccion.put(threadID,con);
		return con;
	}

	public synchronized Connection getConnection()
	{
		// verifico si hay una transaccion abierta
		long threadID = Thread.currentThread().getId();
		Connection con = enTransaccion.get(threadID);
		if( con != null )
		{
			return con;
		}
		
		if( libres.size() <= 0 )
		{
			if( !_crearMasConexiones() )
			{
				throw new RuntimeException("No hay conexiones disponibles");
			}
		}

	   con = libres.remove(0);
		usadas.add(con);
		return con;
	}

	private boolean _crearMasConexiones()
	{
		int actuales = libres.size() + usadas.size();
		int n = Math.min(maxsize - actuales,steep);

		if( n > 0 )
		{
			System.out.println("Creando " + n + " conexiones nuevas...");
			_instanciar(n);
		}

		return n > 0;
	}

	private void _instanciar(int n)
	{
		try
		{
			Connection con;

			for( int i = 0; i < n; i++ )
			{
				con = DriverManager.getConnection(url,usr,pwd);
				con.setAutoCommit(false);
				libres.add(con);
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}	
	
	public synchronized void releaseConnection(Connection con)
	{
		// verifico si la conexion esta afectada a una transaccion
		long threadID = Thread.currentThread().getId();
		if( enTransaccion.get(threadID)!= null )
		{
			return;
		}
		
		boolean ok = usadas.remove(con);
		if( ok )
		{
			libres.add(con);
		}
		else
		{
			throw new RuntimeException("Me devuelve una conexion que no es mia...");
		}
	}
	
	public synchronized void close()
	{
		try
		{
			// cierro las conexiones libres
			for(Connection con: libres)
			{
				con.close();
			}

			// cierro las conexiones usadas
			for(Connection con: usadas)
			{
				con.close();
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	void releaseConnectionForTransaction(Connection con)
	{
		long threadID = Thread.currentThread().getId();
		enTransaccion.remove(threadID);
		releaseConnection(con);
	}
}
