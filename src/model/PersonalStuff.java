package model;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonalStuff extends Items implements Serializable {
    private int quantity;


    public PersonalStuff(String id, String name, int cost) {
        this.setId(id);
        this.setCost(cost);
        this.setName(name);
    }

    @Override
    public double getPrice() {
        return quantity*this.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusYears(1);
    }


    public PersonalStuff(String id, String name, int cost, LocalDate manufacturingDate, int quantity) {
        super(id, name, cost, manufacturingDate);
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString() +
                " PersonalStuff{" +
                "quantity=" + quantity +
                '}';
    }
}
