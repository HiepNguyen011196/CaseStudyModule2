package model;

import java.time.LocalDate;

public class Drinks extends Items {
    private int quantity;
    private LocalDate manufacturingDate;

    public Drinks() {
    }

    public Drinks(String id, String name, int cost, int quantity, LocalDate manufacturingDate) {
        super(id, name, cost);
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }
}
