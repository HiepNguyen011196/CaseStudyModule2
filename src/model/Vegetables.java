package model;

import java.time.LocalDate;

public class Vegetables extends Items {
    private int weight;
    private LocalDate manufacturingDate;

    public Vegetables() {
    }

    public Vegetables(String id, String name, int cost, int weight, LocalDate manufacturingDate) {
        super(id, name, cost);
        this.weight = weight;
        this.manufacturingDate = manufacturingDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }
}
