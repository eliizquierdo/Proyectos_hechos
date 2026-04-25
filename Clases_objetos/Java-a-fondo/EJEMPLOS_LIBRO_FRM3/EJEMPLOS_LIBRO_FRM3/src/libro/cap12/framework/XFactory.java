package libro.cap12.framework;

import java.util.Hashtable;

import libro.cap12.framework.xml.XMLFactory;
import libro.cap12.framework.xml.XTag;



public class XFactory
{
	private static XFactory instancia;
	
	private XSession session;
	private XConnectionPool connectionPool;
	private Hashtable<String,Object> beans=null;
	
	private XFactory()
	{
		session = new XSession();
		connectionPool = new XConnectionPool();
		beans = new Hashtable<String, Object>();
	}
	
	public static void load(String xmlfilename)
	{
		XMLFactory.load(xmlfilename);
	}
	
	public Object getBean(String bname)
	{
		Object o = beans.get(bname);
		if( o == null )
		{
			o = _instanciarBean(bname);
			beans.put(bname,o);
		}
		return o;
	}
	
	private Object _instanciarBean(String bname)
	{
		try
		{
			String path="/framework/bean-access/bean";
			String attname="name";
			
			XTag t = XMLFactory.getByAttribute(path,attname,bname);

			String sclazz = t.getAtts().get("type");
			return Class.forName(sclazz).newInstance();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public static XFactory getInstancia()
	{
		if( instancia == null )
		{
			instancia = new XFactory();
		}
		
		return instancia;
	}	
	
	public XConnectionPool getConnectionPool()
	{
		return connectionPool;
	}
	
	public XSession getSession()
	{
		return session;
	}
}
