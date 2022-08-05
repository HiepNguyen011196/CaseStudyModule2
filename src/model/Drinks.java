package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Drinks extends Items implements Serializable {
    private int quantity;


    public Drinks(String id, String name, int cost) {
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
        return this.getManufacturingDate().plusWeeks(2);
    }


    public Drinks(String id, String name, int cost, LocalDate manufacturingDate, int quantity) {
        super(id, name, cost, manufacturingDate);
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString()
                +" Drinks{" +
                "quantity=" + quantity +
                '}';
    }
}
