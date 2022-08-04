package controller;

import model.Items;
import storage.ReadWriteData;
import storage.ReadWriteFileBinary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Manager {
//   ReadWriteData readWriteFileBinary = ReadWriteFileBinary.getInstance();
    private final ReadWriteData<Items> readWriteFileBinary = ReadWriteFileBinary.getInstance();
//    List<Items> itemsList = readWriteFileBinary.readData("item.dat");
    List<Items> itemsList= new ArrayList<>();

    public void add(Items items) {
        itemsList.add(items);
        readWriteFileBinary.writeData("item.dat", itemsList);
    }

    public void display() {
        int count = 1;
        System.out.println("[Number of item: " + itemsList.size() + "]\n");
        if (itemsList.size() == 0) {
            System.err.println("There is no item !!!");
        } else {
            for (Items items : itemsList) {
                System.out.print("[" + (count++) + "]\t");
                System.out.println(items);
            }
        }
    }

    public void delete(int index) {
        if (itemsList.size() > 0) {
            for (int i = 0; i < itemsList.size(); i++) {
                if (i == (index - 1)) {
                    itemsList.remove(i);
                    writeFile();
                }
            }
        } else if (index >= itemsList.size()) {
            System.err.println("INDEX NOT EXIST");
        } else
            System.err.println("LIST IS EMPTY !!!");
        readWriteFileBinary.writeData("item.dat", itemsList);
    }

    public void writeFile() {
        readWriteFileBinary.writeData("item.dat", itemsList);
    }

    public void readFile() {
        itemsList = (List<Items>) readWriteFileBinary.readData("item.dat");
    }

    public void deleteAll() {
        itemsList.clear();
        readWriteFileBinary.writeData("item.dat", itemsList);
    }

    public void editName(String id, String editName) {
        for (Items i : itemsList) {
            if(Objects.equals(i.getId(), id))
                i.setName(editName);
        }
        readWriteFileBinary.writeData("item.dat", itemsList);
    }

    public void editCost(String id, double cost) {
        for (Items i : itemsList) {
            if(Objects.equals(i.getId(), id))
                i.setCost(cost);
        }
        readWriteFileBinary.writeData("item.dat", itemsList);
    }

    public void sortByCostHighToLow() {
        itemsList.sort(((o1, o2) -> {
            return Double.compare(o2.getCost(), o1.getCost());
        }));
        display();
    }

    public void sortByCostLowToHigh() {
        itemsList.sort((Comparator.comparingDouble(Items::getCost)));
        display();
    }
}