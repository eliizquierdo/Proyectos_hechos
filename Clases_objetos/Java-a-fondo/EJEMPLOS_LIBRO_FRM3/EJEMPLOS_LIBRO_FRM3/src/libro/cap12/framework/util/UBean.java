package libro.cap12.framework.util;

import java.lang.reflect.Method;

public class UBean
{
	public static String getSetterName(String attName)
	{
		return UString.switchCase("set"+attName,3);
	}

	public static String getGetterName(String attName)
	{
		return UString.switchCase("get"+attName,3);
	}	
	
	public static void main(String[] args)
	{
		System.out.println(getSetterName("nombre"));
	}

	@SuppressWarnings("unchecked")
	public static Object invoqueGetter(Object dto, String att)
	{
		try
		{
			String mtdName = getGetterName(att);
			Class[] parameterTypes = new Class[0];
			Method mtd = dto.getClass().getMethod(mtdName,parameterTypes);
			
			Object[] parameterValues = new Object[0]; 
			return mtd.invoke(dto,parameterValues);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public static void invoqueSetter(Object dto, String attName, Object value)
	{
		try
		{
  			String mtdName=getSetterName(attName);  			
			Class[] argsType = { value.getClass() };
			
			
			Method mtd = null ;
			try
			{
				mtd = dto.getClass().getMethod(mtdName,argsType);	
			}
			catch(NoSuchMethodException ex)
			{ 
				argsType[0] =_wrapperToType(value.getClass());
				mtd = dto.getClass().getMethod(mtdName,argsType);
			}
			
			mtd.invoke(dto,value);			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	private static Class _wrapperToType(Class clazz)
	{
		if( clazz.equals(Byte.class) ) return Byte.TYPE;
		if( clazz.equals(Short.class) ) return Short.TYPE;
		if( clazz.equals(Integer.class) ) return Integer.TYPE;
		if( clazz.equals(Long.class) ) return Long.TYPE;
		if( clazz.equals(Character.class) ) return Character.TYPE;
		if( clazz.equals(Float.class) ) return Float.TYPE;
		if( clazz.equals(Double.class) ) return Double.TYPE;

		return clazz;
	}
}
