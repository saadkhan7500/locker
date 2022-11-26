package com.locker.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.locker.dao.Dao;

import java.io.File;

public class Controller {

	

	public static void main(String[] args) throws IOException 
	{
		 File file = new File("D://main_directory");
	      //Creating the directory
	     file.mkdir();
	     
		
		Dao dao = new Dao();
		int choice;
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
       
       switch(option)
       {
          case 1: {
		        	  //To get all files in specified directory   
			           List<String> files =dao.getAllFiles();
			           
			           
			           System.out.println(files);
			           
			           break;
        	        
                  }
          
          case 2: {
        	         
                  }
          
          case 3: {
        	  
            }
          
          case 4: {
        	  //To delete a file  
        	  
          }
          case 5: {
        	  //To do exit
  	          
	           
	           break;
         }
	        
          
       }
       
       System.out.println("Do you want to continue? press 1 for Yes press 0 for No");
	   
	   choice = sc.nextInt();
	   }
	   while(choice==1);

	}

}
