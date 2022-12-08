package com;

import java.io.*;

import java.lang.System;


public class LockedmeMain {
	

	public static void main(String[] args) {
		
		//printing welcome screen
		
		
		//String Locker = String.format("Hello User /n Welcome to LockedMe.com Developed by sruthisree \n");
		
		String LockerApp ="This application help you to :: \n"
				
				+ "Add or delete files in \"main\" folder \n"
				
				+ "Retrieve all files in the \"main\" folder \n";
				
				
		System.out.println("Hello User \n Welcome to LockedMe.com Developed by sruthisree \n");

		System.out.println(LockerApp);
		
		createFolderIfNotPresent("main");
		
		
		// Display options for user
		
		PrimaryOptions.InputFromWelcomeScreen();
		
		
	}
	
	
		public static void createFolderIfNotPresent(String folderName) {
			File file = new File(folderName);		
			if (!file.exists()) {
				file.mkdirs();
			
		}
	
	
    }

}


