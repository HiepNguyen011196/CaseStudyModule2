package model;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonalStuff extends Items implements Serializable {
    private int quantity;

    public PersonalStuff(String id, int cost) {
    }

    public PersonalStuff(String id, int cost, String name) {
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
        return "PersonalStuff{" +
                "quantity=" + quantity +
                super.toString() +
                '}';
    }
}
