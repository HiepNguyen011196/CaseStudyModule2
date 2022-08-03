package model;

public class Proteins extends Items {
    private int weight;
    private String type;

    public Proteins() {
    }

    public Proteins(String id, String type, String name, int cost, int weight) {
        super(id, name, cost);
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
