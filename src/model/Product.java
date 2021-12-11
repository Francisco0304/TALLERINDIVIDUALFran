package model;

public class Product {
	
	private int id;
	private String name;
	private double unitValue;
	private int existingQuantity;

	public Product(int id, String name, double unitValue, int existingQuantity) {
		this.id = id;
		this.name = name;
		this.unitValue = unitValue;
		this.existingQuantity = existingQuantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}

	public int getExistingQuantity() {
		return existingQuantity;
	}

	public void setExistingQuantity(int existingQuantity) {
		this.existingQuantity = existingQuantity;
	}

}
