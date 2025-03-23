package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Jetimpl;

public class AirField {
	private Scanner scanner;

	private List<Jet> fleet = new ArrayList<>();

	public AirField() {
		this.scanner = new Scanner(System.in);
		loadJetsFromFile("JetData.txt");
		// load 5 jets here.
		// loadJetsFromFile("jetData.txt");
	}

	public void listFleet() {
		if (fleet.isEmpty()) {
			System.out.println("Fleet is empty.");
			return;
		}
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			String type;
			
			if(jet instanceof FighterJet) {
				type = "Fighter Jet";
			} else if (jet instanceof CargoJet) {
				type = "Cargo Jet";
			}else {
				type = "Standard Jet";
			}
			
			System.out.println((i + 1) + ".[" + type + "] " + jet.getModel());
		}
	}

	public void loadJetsFromFile(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jetData.txt"))) {
			String line = "";
			while ((line = bufIn.readLine()) != null) {
				System.out.println(line);
				String[] fields = line.split("[|]");
				String type = fields[0];
				String model = fields[1];
				Jet jet = null;
				double speed = Double.parseDouble(fields[2]);
				int range = Integer.parseInt(fields[3]);
				long price = Long.parseLong(fields[4]);
				switch (type) {
				case "B":
					jet = new Jetimpl(model, speed, range, price);
					break;
				case "C":
					jet = new CargoJet(model, speed, range, price);
					break;
				case "F":
					jet = new FighterJet(model, speed, range, price);
					break;
				default:
					System.out.println("Unknown Jet type: ");
					continue;
				}

				fleet.add(jet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public void flyAllJets() {
		for (Jet jet : fleet) {
			jet.fly();
		}

	}

	public void viewFastestJet() {
		if (fleet.isEmpty()) {
			System.out.println("Fleet is empty.");
			return;
		}
		Jet fastestJet = fleet.get(0);

		for (Jet jet : fleet) {
			if (jet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jet;

			}
		}
		System.out.println("Fastest Jet: ");
		System.out.println(fastestJet);

		// TODO BufferReader recipe here to read from fileName
	}

	public void viewLongestRange() {
		if (fleet.isEmpty()) {
			System.out.println("Fleet is empty.");
			return;
		}
		Jet longestRange = fleet.get(0);

		for (Jet jet : fleet) {
			if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		System.out.println("Longest range Jet: ");
		System.out.println(longestRange);
	}

	public void loadAllCargoJets() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoJet) {
				((CargoJet) jet).loadCargo();
			}
		}

	}

	public void fightReady() {
		List<Jet> fighterJets = new ArrayList<>();

		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
				fighterJets.add(jet);
			}
		}
		if (fighterJets.size() > 0) {
			int randomWinner = (int) (Math.random() * fighterJets.size());
			Jet WinningJet = fighterJets.get(randomWinner);
			String winner = WinningJet.getModel();
			System.out.println(winner + " Won the fight!");

		}
	}

	public void addJet() {
		System.out.println("Select Jet type to add:");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Jet");
		System.out.println("3. Standard Jet");

		int choice = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter model:");
		String model = scanner.nextLine();

		System.out.println("Enter speed (mph):");
		double speed = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter range in miles");
		int range = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter price: ");
		long price = scanner.nextLong();
		scanner.nextLine();

		Jet newJet = null;

		switch (choice) {
		case 1:
			newJet = new FighterJet(model, speed, range, price);
			break;
		case 2:
			newJet = new CargoJet(model, speed, range, price);
			break;
		case 3:
			newJet = new Jetimpl(model, speed, range, price);
			break;
		default:
			System.out.println("Invalid choice Jet has not been added.");
			return;

		}

		fleet.add(newJet);
		System.out.println("Jet has been successfully added!");

	}

	public void remove() {
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			String type;
			
			if(jet instanceof FighterJet) {
				type = "Fighter Jet";
			} else if (jet instanceof CargoJet) {
				type = "Cargo Jet";
			}else {
				type = "Standard Jet";
			}
			
			System.out.println((i + 1) + ".[" + type + "] " + jet.getModel());
			
		}
		System.out.println("Which jet do you want to remove? Enter the number:");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		if(choice <1 || choice > fleet.size()){
			System.out.println("Invalid choice. No jet has been removed.");
			return;
		}
		
		Jet removedJet = fleet.remove(choice - 1);
		System.out.println(removedJet.getModel() + "has been removed");
	}

}
