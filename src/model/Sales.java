package model;

public class Sales {
    private int id;
    private String name;
    private double unitValue;
    private int total;

    public Sales(int id, String name, double unitValue, int total) {
        this.id = id;
        this.name = name;
        this.unitValue = unitValue;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
