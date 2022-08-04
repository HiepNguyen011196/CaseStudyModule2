package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Vegetables extends Items implements Serializable {
    private int weight;

    public Vegetables(String id, int cost) {
    }

    public Vegetables(String id, int cost, String name) {
    }

    @Override
    public double getPrice() {
        return weight*this.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusDays(4);
    }

    public Vegetables(String id, String name, int cost, LocalDate manufacturingDate) {
        super(id, name, cost, manufacturingDate);
    }

    @Override
    public String toString() {
        return "Vegetables{" +
                "weight=" + weight +
                super.toString() +
                '}';
    }
}
