package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenericUtility 
{
	public static String getCurrentDate()
	{
		SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");  
	    Date date= new Date();
	    String currentDate= df.format(date);
	    //System.out.println("Current Date= "+currentDate);
		return currentDate;
	}
	
	public static String generateRandomString(int length) 
	{
		String smallLetters= "abcdefghijklmnopqrstuvwxyz";
		String capitalLetters= smallLetters.toUpperCase();
		String number= "0123456789";
		String dataForRandomString= smallLetters+ capitalLetters+ number;
		
		Random random = new Random();
		String randomString="";
		if(length>1)
		{
			StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) 
	        {
	            int randomCharAt = random.nextInt(dataForRandomString.length());
	            char randomChar = dataForRandomString.charAt(randomCharAt);
	            randomString= "auto_"+sb.append(randomChar).toString();
	        }
		}
		System.out.println("Random String= "+ randomString);
		return randomString;	
	}
	
	public static int generateRandomNumber()	//doubt
	{
		
		Random random = new Random(); 
		int random_number= random.nextInt(Integer.MAX_VALUE);
		System.out.println("Random Number= auto_"+ random_number);
		return random_number;
	}
	
	public static void copyFileUsingStream(File source, File destination) throws IOException 
	{
		InputStream inputStream = null;
        OutputStream outputStream = null;
        
        try 
        {
        	inputStream = new FileInputStream(source);
        	outputStream = new FileOutputStream(destination);
        	
            byte[] buffer = new byte[1024];
            int length;
            while((length = inputStream.read(buffer))> 0)
            {
            	outputStream.write(buffer, 0, length);
            }
        } 
        finally 
        {
        	inputStream.close();
        	outputStream.close();
        }
	}
}
