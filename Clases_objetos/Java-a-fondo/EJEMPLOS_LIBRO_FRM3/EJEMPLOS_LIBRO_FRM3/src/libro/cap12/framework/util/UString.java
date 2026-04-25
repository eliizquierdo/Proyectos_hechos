package libro.cap12.framework.util;

public class UString
{
	public static String switchCase(String s, int i)
	{
		String x1 = s.substring(0,i);
		int c= s.charAt(i);
		String x2 = s.substring(i+1);
		
		if( c>='A' && c<='Z' )
		{
			c = c + 'a' - 'A';
		}
		else
		{
			if( c>='a' && c<='z' )
			{
				c= c+ 'A' - 'a';
			}
		}
		
		return x1+(char)c+x2;
	}
	
	public static String replicate(String x,int n, String separator)
	{
		String aux;
		StringBuffer buff = new StringBuffer();
		for(int i=0; i<n; i++)
		{
			buff.append(x);
			aux = (i<n-1)?separator:"";
			buff.append(aux);
		}
		
		return buff.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(replicate("Pablo",4,","));
	}
}
