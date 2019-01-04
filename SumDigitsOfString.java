import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class SumDigitsOfString {
public long addDigits_Default(String s)
{
	long result= 0;
	for(int i=0;i<s.length();i++)
	{
		if(Character.isDigit(s.charAt(i))) //If character is digit then add Numeric value to result
			result=result+Character.getNumericValue(s.charAt(i));
	}
	return result;
}
public long addHexDigits(String s)
{
	long result= 0;
	for(int i=0;i<s.length();i++)
	{
		char t=s.charAt(i);
		if(Character.isDigit(t) || (t >= 'a' && t <= 'f' || t >= 'A' && t <= 'F')) //For handling Hexadecimal values
			result=result+Integer.parseInt(s.charAt(i)+"",16);
	}
	return result;
}

public long addDigitsFromFile(String filePath) throws IOException
{
	File file = new File(filePath);
	long result=0;
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in);//Read the file
             Reader buffer = new BufferedReader(reader)) 
        {
        	int r =0;
	        	while ((r = reader.read()) != -1) 
	        	{
	                char ch = (char) r; // check for digits
	                if(Character.isDigit(ch))
	            		result=result+Character.getNumericValue(ch);
	
	            }
        }
    
    return result;
}
	public static void main(String[] args) throws IOException 
	{
		SumDigitsOfString sum=new SumDigitsOfString();
		
		Scanner me=new Scanner(System.in);
	
		if(args.length == 0) //add digits - Default
		{
			
			System.out.println(sum.addDigits_Default(me.nextLine()));
		}
		else if(args[0].equals("-x")) //add digits - Hexadecimal
		{
			
			System.out.println(sum.addHexDigits(me.nextLine()));
		}
		else if(args[0].equals("-f")) // add digits - File Content
		{
			System.out.println(sum.addDigitsFromFile(args[1]));
		}
		
	}

}
