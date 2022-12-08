package com;


import java.util.*;

public class PrimaryOptions {
	
	//handle welcome screen input
	
	public static void InputFromWelcomeScreen() {  
		boolean flow = true;
		Scanner sc = new Scanner(System.in);
		//FileOperations.ShowMenu();
		do {
			try {
				FileOperations.ShowMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileOperations.ShowAllFiles("main");
					break;
				case 2:
					FileOperations.FileMenuOperations();
					SecondaryMenu.SecondaryMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					flow = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				System.out.println("Reload the app and \n then please Enter valid option from 1 to 3 ");
				InputFromWelcomeScreen();
				//break;
				
			} 
		} while (flow == true);
		
	
		
	}
	
	
	
	

}
