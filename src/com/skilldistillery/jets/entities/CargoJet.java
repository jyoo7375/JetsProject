package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier{

	public CargoJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadCargo() {
		System.out.println(getModel() + "Cargo door is open and is now ready for loading.");
	}

}
