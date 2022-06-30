package models;

public class Currency {
    private String name;
    private String unit;
    private double value;
    private String type;

    public Currency() {
    }

    public Currency(String name, String unit, double value, String type) {
        this.name = name;
        this.unit = unit;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        String currency = String.format("Name: %s\nUnit: %s\nValue: %f\nType: %s", this.name, this.unit, this.value, this.type);
        return currency;
    }
}
