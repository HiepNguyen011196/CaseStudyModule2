package main;

import controller.Manager;
import model.*;
import validate.Validate;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static Scanner scanner = new Scanner(System.in);
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
            System.out.println("OPTION 0: EXIT");
            System.out.println("----------------------------------------------");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
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
                        deleteItems(itemsManager);
                        break;
                    case 5:
                        itemsManager.sortByCostHighToLow();
                        break;
                    case 6:
                        itemsManager.sortByCostLowToHigh();
                        break;
                    case 0:
                        System.err.println("BYE");
                        return;
                    default:
                        System.err.println("PLEASE ENTER AGAIN");
                }
            } catch (NumberFormatException e) {
                System.err.println("MUST ENTER NUMBER !");
            }
        }
    }

    private static void deleteItems(Manager items) {
        System.out.println("Nhập mã sản phẩm mún xóa:");
        String code = scanner.nextLine();
        if (validate.validateId(code)) {
            items.delete(Integer.parseInt(code));
        } else {
            System.err.println("Cú pháp không hợp lệ!!!!");
            System.out.println();
        }
    }

    private static void addItems(Manager items) {
        System.out.println("ENTER ITEM TO ADD:");
        Scanner scc = new Scanner(System.in);
        String ID = scc.nextLine();
        if (validate.validateId(ID)) {
            String type = ID.substring(0, 2);
            items.add(addInformation(type, ID));
        } else {
            System.err.println("ERROR!!!!");
            System.out.println();
        }
    }

    private static Items addInformation(String type, String ID) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("ENTER ITEM NAME: ");
        String name1 = scanner2.nextLine();
        System.out.println("ENTER COST: ");
        int cost = scanner2.nextInt();
        return null;
    }


    private static void editItem(Manager items) {
        System.out.println("ENTER ITEM TO EDIT: ");
        String id = scanner.nextLine();
        if (validate.validateId(id)) {
            String Id = id.substring(0, 2);
            items.add(editInformation(Id, items));
        } else {
            System.err.println("CAN'T FIND ID !");
        }
    }

    private static Items editInformation(String id, Manager items) {
        switch (id) {
            case "MD":
            case "PS":
            case "PT":
            case "VG":
            case "DR":
                try {
                    System.out.println("OPTION 1: EDIT NAME");
                    System.out.println("OPTION 2: EDIT COST");
                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("ENTER NEW NAME: ");
                            Scanner name = new Scanner(System.in);
                            String newName = name.nextLine();
                            items.editName(id, newName);
                        }
                        case 2 -> {
                            System.out.println("ENTER NEW COST: ");
                            Scanner cost = new Scanner(System.in);
                            int newCost = cost.nextInt();
                            items.editCost(id, newCost);
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("PLEASE REENTER!!");
                }
        }
        return null;
    }
}





