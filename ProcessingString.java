import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0){
		    String st = s.next();
		    int ans = 0;
		    
		    for( char c : st.toCharArray() ){
		        
		        if( c >= '1' && c <= '9' ){
		            ans += (int)Character.getNumericValue( c );
		        }
		        
		    }
		    
		    System.out.println( ans );
		}
	}
}
