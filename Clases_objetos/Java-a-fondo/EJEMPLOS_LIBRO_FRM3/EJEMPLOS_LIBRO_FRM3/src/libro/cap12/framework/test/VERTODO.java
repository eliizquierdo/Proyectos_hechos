
package libro.cap12.framework.test;

import java.util.Collection;

import libro.cap12.framework.XFactory;
import libro.cap12.framework.XSession;


public class VERTODO
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		XFactory.load("configuracion.xml");
		
		XSession sess = XFactory.getInstancia().getSession();
		
		System.out.println("--- DEPTARTAMENTOS ---");
		Collection<DeptDTO> de = sess.findAll(DeptDTO.class);
		
		for(DeptDTO e : de)
		{
			System.out.println(e);
		}	
		
		System.out.println("--- EMPLEADOS ---");		
		Collection<EmpDTO> ce = sess.findAll(EmpDTO.class);
		
		for(EmpDTO e : ce)
		{
			System.out.println(e);
		}
	}
}
