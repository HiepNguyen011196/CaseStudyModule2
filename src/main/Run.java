package main;

import controller.Manager;
import model.*;
import validate.Validate;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner scanner1 = new Scanner(System.in);
    private static final Validate validate = new Validate();


    public static void main(String[] args) {
        Manager itemsManager = new Manager();
        Medicines panadol = new Medicines("MD01", "panadol", 50000, LocalDate.now(), 3, "flu");
        Drinks milk = new Drinks("DR01", "milk", 12000, LocalDate.now(), 12);
        PersonalStuff toothpaste = new PersonalStuff("PS01", "toothpaste", 40000, LocalDate.now(), 1);
        Proteins chicken = new Proteins("PT01", "chicken", 120000, LocalDate.now(), 2, "meat");
        Vegetables spinach = new Vegetables("VG01", "spinach", 40000, LocalDate.now());
        itemsManager.add(panadol);
        itemsManager.add(chicken);
        itemsManager.add(milk);
        itemsManager.add(toothpaste);
        itemsManager.add(spinach);

        while (true) {
            System.out.println("\n-------------GROCERY LIST-------------");
            System.out.println("OPTION 1: DISPLAY ALL ITEMS");
            System.out.println("OPTION 2: ADD ITEM");
            System.out.println("OPTION 3: EDIT ITEM");
            System.out.println("OPTION 4: REMOVE ITEM");
            System.out.println("OPTION 5: SORT ITEMS BY PRICE FROM HIGH TO LOW");
            System.out.println("OPTION 6: SORT ITEMS BY PRICE FROM LOW TO HIGH");
            System.out.println("OPTION 7: TOTAL COST");
            System.out.println("OPTION 0: EXIT");
            System.out.println("----------------------------------------------");
            try {
                Scanner scanner2 = new Scanner(System.in);
                int choice = Integer.parseInt(scanner2.nextLine());
                switch (choice) {
                    case 1:
                        try {
                            itemsManager.display();
                        } catch (NullPointerException e) {
                            System.err.println("lIST IS EMPTY !!!");
                        }
                        break;
                    case 2:
                        addItems(itemsManager);
                        break;
                    case 3:
                        itemsManager.display();
                        editItem(itemsManager);
                        break;
                    case 4:
                        itemsManager.display();
                        System.out.print("ENTER POSITION OF ITEM TO DELETE:");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        itemsManager.delete(index);
                        break;
                    case 5:
                        itemsManager.sortByCostHighToLow();
                        break;
                    case 6:
                        itemsManager.sortByCostLowToHigh();
                        break;
                    case 7:
                        double totalCost = itemsManager.totalCost();
                        System.out.println("Your total cost is: " + totalCost);
                        break;
                    case 0:
                        System.err.println("BYE");
                        return;
                    default:
                        System.err.println("PLEASE ENTER AGAIN");
                }
            } catch (Exception e) {
                System.err.println("ERROR !");
            }
        }
    }

    private static void addItems(Manager manager) {
        System.out.println("ENTER ITEM TO ADD:");
        String ID = scanner.nextLine();
        if (validate.validateId(ID)) {
            String id = ID.substring(0, 2);
            manager.add(addInformation(id, ID));
        } else {
            System.err.println("ERROR!!!!");
            System.out.println();
        }
    }

    private static Items addInformation(String id, String ID) {
        System.out.println("ENTER ITEM NAME: ");
        String name = scanner1.nextLine();
        System.out.println("ENTER COST: ");
        int cost = scanner.nextInt();
        Items demo = switch (id) {
            case "DR" -> new Drinks(ID, name, cost);
            case "MD" -> new Medicines(ID, name, cost);
            case "PS" -> new PersonalStuff(ID, name, cost);
            case "PT" -> new Proteins(ID, name, cost);
            case "VG" -> new Vegetables(ID, name, cost);
            default -> null;
        };
        ;
        return demo;
    }


    private static void editItem(Manager items) {
        System.out.println("ENTER ITEM TO EDIT:");
        String id = scanner.nextLine();
        if (validate.validateId(id)) {
            try {
                System.out.println("OPTION 1: EDIT NAME");
                System.out.println("OPTION 2: EDIT COST");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.println("ENTER NEW NAME: ");
                        Scanner name = new Scanner(System.in);
                        String newName = name.nextLine();
                        items.editName(id, newName);
                    }
                    case 2 -> {
                        System.out.println("ENTER NEW COST:");
                        Scanner cost = new Scanner(System.in);
                        String newCost = cost.nextLine();
                        items.editCost(id, Double.parseDouble(newCost));
                    }
                }
            } catch(InputMismatchException e){
                System.out.println("WRONG INPUT");
            }
        } else {
            System.err.println("WRONG INPUT!!!!");
            System.out.println();
        }
    }
}





