package com.locker.dao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dao {

	public List<String> getAllFiles() {
		List<String> files = new ArrayList<>();

		String fLocation = "D://main_directory";

		File directoryPath = new File(fLocation);
		// List of all files and directories
		String contents[] = directoryPath.list();

		// List of files and directories in the specified directory:
		for (int i = 0; i < contents.length; i++) {
			files.add(contents[i]);
		}
		// Sorting all the files names
		Collections.sort(files);

		return files;

	}
	
	public boolean addFile(String fileName,String fileLocation ,String fileData )
	{
		boolean status = false;
	
		try {
			FileWriter fw = new FileWriter(fileLocation+"/"+fileName+".txt");
			
			fw.write(fileData);
			System.out.println("File write completed!!");
			fw.close();
	        status = true;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		
		
		return status;
	}

}
