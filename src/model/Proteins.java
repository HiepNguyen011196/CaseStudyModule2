package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Proteins extends Items implements Serializable {
    private int weight;
    private String type;


    public Proteins(String id, String name, int cost) {
        this.setId(id);
        this.setCost(cost);
        this.setName(name);

    }

    @Override
    public double getPrice() {
        return weight*this.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusWeeks(4);
    }


    public Proteins(String id, String name, int cost, LocalDate manufacturingDate, int weight, String type) {
        super(id, name, cost, manufacturingDate);
        this.weight = weight;
        this.type = type;
    }


    @Override
    public String toString() {
        return super.toString() +
                " Proteins{" +
                "weight=" + weight +
                ", type='" + type + '\'' +
                '}';
    }
}
