package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Medicines extends Items implements Serializable {
    private int quantity;
    private String usage;


    public Medicines(String id, String name, int cost) {
        this.setId(id);
        this.setName(name);
        this.setCost(cost);
    }

    @Override
    public double getPrice() {
        return quantity*this.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusYears(2);
    }


    public Medicines(String id, String name, int cost, LocalDate manufacturingDate, int quantity, String usage) {
        super(id, name, cost, manufacturingDate);
        this.quantity = quantity;
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                ", manufacturingDate=" + super.getManufacturingDate() +
                " Medicines{" +
                "usage='" + usage + '\'' +
                '}';
    }
}
