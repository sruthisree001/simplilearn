package com;

import java.util.List;
import java.util.Scanner;


public class SecondaryMenu {
	public static void SecondaryMenuOptions(){
		boolean flow = true;
		Scanner sc = new Scanner(System.in);
		do {
			
			
			try {
				
				int input = sc.nextInt();
				switch (input) {
				
				//case for Adding file
				case 1:
					
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String fileToAdd = sc.next();
					
					FileOperations.createFile(fileToAdd, sc);
					
					break;
					
					//case to delete File
				case 2:
					
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = sc.next();
					
					List<String> filesToDelete = FileOperations.FileLocation(fileToDelete, "main");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int id = sc.nextInt();
					
					if (id != 0) {
						FileOperations.FileDelRecursively(filesToDelete.get(id - 1));
					} else {
						
						// If id == 0, delete all files displayed for the name
						for (String path : filesToDelete) {
							FileOperations.FileDelRecursively(path);
						}
					}
					

					break;
					
					// case to search a File
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fName = sc.next();
					FileOperations.FileLocation(fName, "main");
					PrimaryOptions.InputFromWelcomeScreen();

					//break;
					
					//  Go back to Previous menu
				case 4:
					return;
					
					// case to Exit
				case 5:
					
					System.out.println("Program exited successfully.");
					flow = false;
					sc.close();
					System.exit(0);
					
				default:
					System.out.println("Please select a valid option from above.");
				}
				
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				System.out.println("Reload the app and \n then please Enter valid option from 1 to 5 ");
				break;
			}
			
			
		} while (flow == true);
		
	
	}

}
