package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApplication {
	//No jet Collection in the app class
	//only an Airfield
	
	private AirField airFields = new AirField();
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		JetsApplication app = new JetsApplication();
		app.launch();
		
		scanner.close();
		
	}

	private void launch() {
		int choice = 0;
		
		do {
			displayuserMenu();
			
			System.out.println("Choose menu option:");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			
			case 1:
				airFields.loadJetsFromFile("jetData.txt");
				break;
			case 2:
				airFields.flyAllJets();
				break;
				
			default:
				System.out.println("Invalid option. Please try again");
			}
		}while(choice != 9);
	
		
		
	}
	
		//switch on user choice
		//Call an Airfielld method to act on user choice
		
	
	private void displayuserMenu() {
		System.out.println("+===========================================+");
	    System.out.println("|              AIRFIELD MAIN MENU           |");
	    System.out.println("+===========================================+");
	    System.out.println("| 1.  List fleet                            |");
	    System.out.println("| 2.  Fly all jets                          |");
	    System.out.println("| 3.  View fastest jet                      |");
	    System.out.println("| 4.  View jet with longest range           |");
	    System.out.println("| 5.  Load all Cargo Jets                   |");
	    System.out.println("| 6.  Dogfight!                             |");
	    System.out.println("| 7.  Add a jet to Fleet                    |");
	    System.out.println("| 8.  Remove a jet from Fleet               |");
	    System.out.println("| 9.  Quit                                  |");
	    System.out.println("+===========================================+");
		//TODO -sysouts to show main menu
	}

}
