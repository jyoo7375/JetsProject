package com.skilldistillery.jets.entities;

public abstract class Jet {

	private String model;
	private double speed;
	private int range;
	private long price;

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public void fly() {
		System.out.println(
				model + " is flying at " + speed + " mph ");
		System.out.printf("%.2f in Mach, and its range is %d miles, and it costs $%,d\n", getSpeedInMach(), range, price);
	}

	public double getSpeedInMach() {
		return speed /767.0;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [model=").append(model).append(", speed=").append(speed).append(", range=").append(range)
				.append(", price=").append(price).append("]");
		return builder.toString();
	}

}
