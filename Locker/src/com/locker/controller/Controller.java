package com.locker.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.locker.dao.Dao;

import java.io.File;

public class Controller {
	static int count=0;

	public static void main(String[] args) throws IOException {
		File file = new File("D://main_directory");
		// Creating the directory
		file.mkdir();

		Dao dao = new Dao();
		int choice=0;
		int option;
		System.out.println("Welcome to Locker Application");
		System.out.println("Developed by Mohammad Saad");
		System.out.println();

		do {
			System.out.println("*Please press any following option");
			System.out.println("Default directory - D://main_directory");
			System.out.println("press 1 -> Retreive files from current directory");
			System.out.println("press 2 -> Add a file to the exsiting directory");
			System.out.println("press 3 -> Search a file");
			System.out.println("press 4 -> Delete a file");
			System.out.println("press 5 -> Exit");
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();

			switch (option) {
			case 1: {
				// To get all files in specified directory
				List<String> files = dao.getAllFiles();

				files.stream().forEach(System.out::println);

				break;

			}

			case 2: {
				// Add a file to the exsiting directory
				sc.nextLine();
				System.out.println("Enter file name");
				String fName = sc.nextLine();
				// sc.nextLine();
				System.out.println("Enter the file location");
				String fLocation = sc.nextLine();
				System.out.println("Enter file Data");
				// sc.nextLine();
				String fData = sc.nextLine();
				boolean status = dao.addFile(fName, fLocation, fData);
				if (status)
					System.out.println("File stored successfully");
				else
					System.out.println("File not stored! Enter proper File location");
				break;

			}

			case 3: {
				// Search a file
				sc.nextLine();
				System.out.println("Enter file name");
				String fName = sc.nextLine();
				System.out.println("Enter file Location");
				String fLocatoin = sc.nextLine();

				try {
					BufferedReader br = dao.searchFile(fName, fLocatoin);
					if (br != null) {
						System.out.println(fName + ".txt Found on the given path, below is file content");
						System.out.println("-------------------------------------");
						String st;
						// Condition holds true till
						// there is character in a string
						while ((st = br.readLine()) != null)

							// Print the string
							System.out.println(st);
						System.out.println("--------------------------------------");
					} else {
						System.out.println("File not found!");
					}
                 br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}

			case 4: {
				// To delete a file
				sc.nextLine();
				System.out.println("Enter file name");
				String fName = sc.nextLine();
				System.out.println("Enter file Location");
				String fLocatoin = sc.nextLine();

				if (dao.deleteFile(fName, fLocatoin)) {
					System.out.println("File deleted Successfully");
				} else {
					System.out.println("File not found");
				}

				break;
			}
			case 5: {
				// To do exit
                 count=1;
                 choice=0;
				break;
			}

			}
            if(count!=1)
            {
			  System.out.println("Do you want to continue? press 1 for Yes press 0 for No");
			  choice = sc.nextInt();
            }

			
		} while (choice == 1);
		System.out.println("              ***Thanks for using this application***");

	}

}
