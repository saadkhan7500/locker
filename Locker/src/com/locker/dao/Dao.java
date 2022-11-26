package com.locker.dao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;

public class Dao {

	public List<String> getAllFiles() {
		List<String> files = new ArrayList<>();

		String fLocation = "D://file handling";

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

}
