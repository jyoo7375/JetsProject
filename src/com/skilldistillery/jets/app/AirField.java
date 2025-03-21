package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;

public class AirField {

	private List<Jet> fleet = new ArrayList<>();

	public AirField() {
		// load 5 jets here.
		//loadJetsFromFile("jetData.txt");
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
					jet = new BusinessJet(model, speed, range, price);
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
		for(Jet jet : fleet) {
			jet.fly();
		}
		// TODO BufferReader recipe here to read from fileName
	}

}
