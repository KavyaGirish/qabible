package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NotepadUtility 
{
	static String data;
	
	public static String readSampleNotepad(String filePath) throws FileNotFoundException
	{
		File file1= new File(filePath);
		Scanner sc= new Scanner(file1);
		while (sc.hasNextLine()) 
		{
			data=sc.nextLine();
		}
		sc.close();
		return data;
	}
}
