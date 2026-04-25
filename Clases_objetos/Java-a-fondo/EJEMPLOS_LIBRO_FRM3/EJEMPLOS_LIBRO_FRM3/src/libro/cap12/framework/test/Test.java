
package libro.cap12.framework.test;

import java.sql.Date;
import java.util.GregorianCalendar;

import libro.cap12.framework.XFactory;
import libro.cap12.framework.XSession;
import libro.cap12.framework.XTransaction;

public class Test
{
	public static void main(String[] args)
	{
		XSession sess = XFactory.getInstancia().getSession();
		
		XTransaction trx = sess.beginTransaction();
		
		_insertarDepartamento(32,"X","DLoc");
		_insertarEmpleados(57,5,"S",31);
		
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
