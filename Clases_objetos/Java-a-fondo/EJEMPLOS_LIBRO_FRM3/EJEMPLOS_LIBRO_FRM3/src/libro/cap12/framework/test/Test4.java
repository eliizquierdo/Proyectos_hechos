
package libro.cap12.framework.test;

import libro.cap04.DeptDAO;
import libro.cap12.framework.XFactory;

public class Test4
{
	public static void main(String[] args)
	{
		XFactory.load("configuracion.xml");
		
		DeptDAO dao = (DeptDAO) XFactory.getInstancia().getBean("DEPT");
		
		System.out.println(dao);
	}
}
