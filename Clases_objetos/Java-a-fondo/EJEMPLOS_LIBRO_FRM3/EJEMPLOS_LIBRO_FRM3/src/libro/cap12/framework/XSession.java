package libro.cap12.framework;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import libro.cap12.framework.util.UBean;
import libro.cap12.framework.util.UString;
import libro.cap12.framework.xml.UXml;
import libro.cap12.framework.xml.XTag;


@SuppressWarnings("unchecked")
public class XSession
{
	public XTransaction beginTransaction()
	{		
		// instancio un XTransactionManager
		XTransaction tm = new XTransaction();
		
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		// el tm manejara su propia conexion
		tm.setConnection( pool.getConnectionForTransaction() );
		
		return tm;		
	}
	
	public Collection findAll(Class dtoClass)
	{
		// obtengo el pool de conexiones y le pido una conexion
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		Connection con = pool.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			// armo el query
			String sql= "";
			
			// SELECT campo1, campo2, ...
			sql += "SELECT " + _obtenerListaDeCampos(dtoClass)+" ";
			
			// FROM nombreDeTabla
			sql += "FROM "+ _obtenerNombreDeTabla(dtoClass)+" ";
						
			// preparo la sentencia
			pstm = con.prepareStatement(sql);
						
			// ejecuto el query
			rs = pstm.executeQuery();
			
			ArrayList ret = new ArrayList();
			
			// si existe al menos una fila...
			while( rs.next() )
			{
				// obtengo una instancia del DTO y le seteo los datos tomados del ResultSet
				Object dto = _obtenerInstancia(dtoClass);
				_invocarSetters(dto,rs,dtoClass);
				
				ret.add(dto);
			}
		
			return ret;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
				pool.releaseConnection(con);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	
	public Object findByPrimaryKey(Class dtoClass, Object pk)
	{
		// obtengo el pool de conexiones 
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		// obtengo una conexion
		Connection con = pool.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			// armo el query
			String sql= "";
			
			// SELECT campo1, campo2, ...
			sql += "SELECT " + _obtenerListaDeCampos(dtoClass)+" ";
			
			// FROM nombreDeTabla
			sql += "FROM "+ _obtenerNombreDeTabla(dtoClass)+" ";
			
			// WHERE campoPK = ?
			sql += "WHERE "+ _obtenerClavePrimaria(dtoClass);
			
			// preparo la sentencia
			pstm = con.prepareStatement(sql);
			
			// seteo el parametro sobre la sentencia
			pstm.setObject(1, pk);
			
			// ejecuto el query
			rs = pstm.executeQuery();
			
			// si existe al menos una fila...
			if( rs.next() )
			{
				// obtengo una instancia del DTO y le seteo los datos tomados del ResultSet
				Object dto = _obtenerInstancia(dtoClass);
				_invocarSetters(dto,rs,dtoClass);
				
				// si hay otra fila entonces hay inconsistencia de datos...
				if( rs.next() )
				{
					throw new RuntimeException("Mas de una fila con esa PK");
				}
				
				// retorno el dto
				return dto;
			}
		
			return null;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
				pool.releaseConnection(con);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	
	public Collection findByWhere(Class dtoClass,String where)
	{
		// obtengo el pool de conexiones y le pido una conexion
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		Connection con = pool.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			// armo el query
			String sql= "";
			
			// SELECT campo1, campo2, ...
			sql += "SELECT " + _obtenerListaDeCampos(dtoClass)+" ";
			
			// FROM nombreDeTabla
			sql += "FROM "+ _obtenerNombreDeTabla(dtoClass)+" ";
			sql += where;
						
			// preparo la sentencia
			pstm = con.prepareStatement(sql);
						
			// ejecuto el query
			rs = pstm.executeQuery();
			
			ArrayList ret = new ArrayList();
			
			// si existe al menos una fila...
			while( rs.next() )
			{
				// obtengo una instancia del DTO y le seteo los datos tomados del ResultSet
				Object dto = _obtenerInstancia(dtoClass);
				_invocarSetters(dto,rs,dtoClass);
				
				ret.add(dto);
			}
		
			return ret;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
				pool.releaseConnection(con);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}		
	}

	public int insert(Object dto)
	{
		// obtengo el pool de conexiones y le pido una conexion
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		Connection con = pool.getConnection();
		PreparedStatement pstm = null;
		
		try
		{
			// armo el query
			String sql= "";
			
			int cantCampos = _obtenerCantidadDeCampos(dto);
			
			// SELECT campo1, campo2, ...
			sql += "INSERT INTO "+ _obtenerNombreDeTabla(dto.getClass())+"( ";
			sql += _obtenerListaDeCampos(dto.getClass())+") ";
			sql += "VALUES ( "+ UString.replicate("?",cantCampos,",")+" )";
			
			// preparo la sentencia
			pstm = con.prepareStatement(sql);
			
			// seteo el parametro sobre la sentencia
			_setearParametrosEnStatement(pstm,dto);
			
			// ejecuto el insert
			return pstm.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( pstm!=null ) pstm.close();
				pool.releaseConnection(con);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	private void _setearParametrosEnStatement(PreparedStatement pstm, Object dto)
	{
		try
		{
   		XTag[] fields = UXml.getFieldsTAG(dto.getClass().getName());
   		
   		Object value;
   		
   		for( int i=0; i<fields.length; i++ )
   		{
   			value = UBean.invoqueGetter(dto,fields[i].getAtts().get("att"));
   			pstm.setObject(i+1,value);
   		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
	}

	private int _obtenerCantidadDeCampos(Object dto)
	{
		XTag[] fields = UXml.getFieldsTAG(dto.getClass().getName());
		return fields.length;
	}

	private void _invocarSetters(Object dto, ResultSet rs, Class dtoClass)
	{
		try
		{
			XTag[] fields = UXml.getFieldsTAG(dto.getClass().getName());
   		
   		Object value;
   		String attName;
   		for( int i=0; i<fields.length; i++ )
   		{
   			attName=fields[i].getAtts().get("att");
   			value = rs.getObject(fields[i].getAtts().get("name"));
   			UBean.invoqueSetter(dto,attName,value);
    		}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	private Object _obtenerInstancia(Class dtoClass)
	{
		try
		{
			return dtoClass.newInstance();	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	private String _obtenerClavePrimaria(Class dto)
	{		
		XTag[] fields = UXml.getFieldsTAG(dto.getName());
		
		boolean isPK;
		String sPk;
		String ret="";
		for( int i=0; i<fields.length; i++ )
		{
			sPk=fields[i].getAtts().get("pk");
			isPK = sPk!=null?sPk.equals("true"):false;
			if( isPK )
			{
				if( i>0 )
				{
					ret+=", ";
				}
				ret+=fields[i].getAtts().get("name")+" = ? ";
			}
		}
		
		return ret;
	}

	private String _obtenerNombreDeTabla(Class dto)
	{
		XTag tt = UXml.getTableTAG(dto.getName());
		return tt.getAtts().get("name");
	}

	private String _obtenerListaDeCampos(Class dto)
	{
		XTag[] fields = UXml.getFieldsTAG(dto.getName());
		
		String ret="";
		for( int i=0; i<fields.length; i++ )
		{
			ret+=fields[i].getAtts().get("name")+((i<fields.length-1)?", ":"");
		}
		
		return ret;
	}	
}
