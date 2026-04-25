
package libro.cap12.framework.test;

import java.sql.Date;

import libro.cap12.framework.XFactory;
import libro.cap12.framework.XSession;
import libro.cap12.framework.XTransaction;

public class Test2
{
	public static void main(String[] args)
	{
		XFactory.load("configuracion.xml");
		XSession sess = XFactory.getInstancia().getSession();
		
		XTransaction trx = sess.beginTransaction();
		
		_insertarDepartamento(89,"ENTRA","ENTRA");
		_insertarEmpleados(155,5,"S",89);
		
		trx.commint();
		
	}
	
	private static void _insertarDepartamento(int deptno, String dname, String loc)
	{
		DeptDTO dto = new DeptDTO();
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		XSession sess = XFactory.getInstancia().getSession();
		sess.insert(dto);
	}

	private static void _insertarEmpleados(int empno, int n, String ename, int deptno)
	{
		
		EmpDTO dto = new EmpDTO();
		
		
		XSession sess = XFactory.getInstancia().getSession();
		
		for(int i=0; i<n; i++ )
		{
			dto.setEmpno(empno+i);
			dto.setEname(ename+" - "+i);
			dto.setDeptno(deptno);
			dto.setHiredate(new Date(System.currentTimeMillis()));
			sess.insert(dto);
		}
	}	
}
