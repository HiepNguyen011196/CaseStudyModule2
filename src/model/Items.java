package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Items implements Serializable {
    private String id, name;
    private double cost;
    private LocalDate manufacturingDate;

    public abstract double getPrice();
    public abstract LocalDate getExpiryDate();
    public Items() {
    }

    public Items(String id, String name, double cost, LocalDate manufacturingDate) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }
}
