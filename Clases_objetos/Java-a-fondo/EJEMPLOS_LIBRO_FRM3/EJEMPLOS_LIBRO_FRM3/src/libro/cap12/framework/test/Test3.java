
package libro.cap12.framework.test;

import java.sql.Date;

import libro.cap12.framework.XFactory;
import libro.cap12.framework.XSession;
import libro.cap12.framework.XTransaction;

public class Test3
{
	public static void main(String[] args)
	{
		XFactory.load("configuracion.xml");
		
		// defino un DeptDTO
		DeptDTO ddto = new DeptDTO();
		ddto.setDeptno(50);
		ddto.setDname("Marketing");
		ddto.setLoc("Islas Canarias");
		
		// defino un EmpDTO
		EmpDTO edto = new EmpDTO();
		edto.setEmpno(332);
		edto.setEname("Josecito");
		edto.setHiredate(new Date(System.currentTimeMillis()));
		edto.setDeptno(ddto.getDeptno());
		
		// obtengo la session
		XSession sess = XFactory.getInstancia().getSession();
		
		//inserto ambos
		XTransaction trx = sess.beginTransaction();
		sess.insert(ddto);
		sess.insert(edto);
		trx.commint();
	}
}
