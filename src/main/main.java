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

        while(true) {
            System.out.println("\n-------------GROCERY LIST-------------");
            System.out.println("OPTION 1: DISPLAY ALL ITEMS");
            System.out.println("OPTION 2: ADD ITEM");
            System.out.println("OPTION 3: EDIT ITEM");
            System.out.println("OPTION 4: REMOVE ITEM");
            System.out.println("OPTION 5: SORT ITEMS BY PRICE");
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
                        removeItems(itemsManager);
                        break;
                    case 5:
                        itemsManager.sortByCost();
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


    private static void editItem(Manager items){
        System.out.println("ENTER ITEM TO EDIT: ");
        String id = scanner.nextLine();
        if (validate.validateId(id)) {
            String Id = id.substring(0, 2);
            items.add(editInformation(id, items));
        } else {
            System.err.println("CAN'T FIND ID !");
        }
    }

    private static Items editInformation(String id, Manager items) {
        switch (id) {
            case "MD":
                try {
                    System.out.println("OPTION 1: EDIT NAME");
                    System.out.println("OPTION 2: EDIT COST");
                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("ENTER NEW NAME: ");
                            Scanner name = new Scanner(System.in);
                            String newName = name.nextLine();
                            items.editName(id, newName);
                        case 2:
                            System.out.println("ENTER NEW COST: ");
                            Scanner cost = new Scanner(System.in);
                            int newCost = cost.nextInt();
                            items.editCost(id, newCost);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("PLEASE REENTER!!");
                }


            case "PA":
                try {
                    System.out.println("Nhập 1: Sửa tên");
                    System.out.println("Nhập 2: Sửa màu");
                    System.out.println("Nhập 3: Sửa hãng");
                    System.out.println("Nhập 4: Sũa giá");
                    Scanner scan = new Scanner(System.in);
                    int choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Mời bạn nhập vào tên mới:");
                            Scanner name = new Scanner(System.in);
                            String newName = name.nextLine();
                            items.editName(code, newName);
                            break;
                        case 2:
                            System.out.println("Mời bạn nhập vào màu mới:");
                            Scanner color = new Scanner(System.in);
                            String newColor = color.nextLine();
                            items.editColor(code, newColor);
                            break;
                        case 3:
                            System.out.println("Mời bạn nhập vào hãng mới:");
                            Scanner brand = new Scanner(System.in);
                            String newBrand = brand.nextLine();
                            items.editBrand(code, newBrand);
                            break;
                        case 4:
                            System.out.println("Mời bạn nhập vào giá mới:");
                            Scanner price = new Scanner(System.in);
                            Double newPrice = price.nextDouble();
                            items.editPrice(code, newPrice);
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai, vui lòng nhập lại");
                }
                break;
            case "JA":
                try {
                    System.out.println("Nhập 1: Sửa tên");
                    System.out.println("Nhập 2: Sửa màu");
                    System.out.println("Nhập 3: Sửa hãng");
                    System.out.println("Nhập 4: Sũa giá");
                    System.out.println("Nhập 5: Sũa loại vải");
                    Scanner scan = new Scanner(System.in);
                    int choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Mời bạn nhập vào tên mới:");
                            Scanner name = new Scanner(System.in);
                            String newName = name.nextLine();
                            items.editName(code, newName);
                            break;
                        case 2:
                            System.out.println("Mời bạn nhập vào màu mới:");
                            Scanner color = new Scanner(System.in);
                            String newColor = color.nextLine();
                            items.editColor(code, newColor);
                            break;
                        case 3:
                            System.out.println("Mời bạn nhập vào hãng mới:");
                            Scanner brand = new Scanner(System.in);
                            String newBrand = brand.nextLine();
                            items.editBrand(code, newBrand);
                            break;
                        case 4:
                            System.out.println("Mời bạn nhập vào giá mới:");
                            Scanner price = new Scanner(System.in);
                            Double newPrice = price.nextDouble();
                            items.editPrice(code, newPrice);
                            break;
                        case 5:
                            System.out.println("Mời bạn nhập vào loại vải mới:");
                            Scanner fabric = new Scanner(System.in);
                            String newFabric = fabric.nextLine();
                            items.editJacketFabric(code, newFabric);
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai, vui lòng nhập lại");
                    editInformation(type, code, items);
                }
                break;
            case "BE":
                try {
                    System.out.println("Nhập 1: Sửa tên");
                    System.out.println("Nhập 2: Sửa màu");
                    System.out.println("Nhập 3: Sửa hãng");
                    System.out.println("Nhập 4: Sũa giá");
                    System.out.println("Nhập 5: Sũa loại da");
                    Scanner scan = new Scanner(System.in);
                    int choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Mời bạn nhập vào tên mới:");
                            Scanner name = new Scanner(System.in);
                            String newName = name.nextLine();
                            items.editName(code, newName);
                            break;
                        case 2:
                            System.out.println("Mời bạn nhập vào màu mới:");
                            Scanner color = new Scanner(System.in);
                            String newColor = color.nextLine();
                            items.editColor(code, newColor);
                            break;
                        case 3:
                            System.out.println("Mời bạn nhập vào hãng mới:");
                            Scanner brand = new Scanner(System.in);
                            String newBrand = brand.nextLine();
                            items.editBrand(code, newBrand);
                            break;
                        case 4:
                            System.out.println("Mời bạn nhập vào giá mới:");
                            Scanner price = new Scanner(System.in);
                            Double newPrice = price.nextDouble();
                            items.editPrice(code, newPrice);
                            break;
                        case 5:
                            System.out.println("Mời bạn nhập vào loại da mới:");
                            Scanner leather = new Scanner(System.in);
                            String newLeather = leather.nextLine();
                            items.editLeather(code, newLeather);
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai, vui lòng nhập lại");
                    editInformation(type, code, items);
                }
                break;
            default:
                System.out.println("Sản phẩm không tồn tại!!");
                break;
        }
        return null;
    }

    private static void addItems(Manager items) {
        System.out.println("Nhập mã sản phẩm:");
        String code = scanner.nextLine();
        if (validate.validateCode(code)) {
            String type = code.substring(0, 2);
            items.add(addInfomation(type, code));
        } else {
            System.err.println("Cú pháp không hợp lệ!!!!");
            System.out.println();
        }
    }

    private static Items addInfomation(String type, String code) {
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.println("Nhập màu sắc sản phẩm:");
        String color = scanner.nextLine();
        System.out.println("Nhập nhãn hiệu sản phẩm:");
        String brand = scanner.nextLine();
        System.out.println("Nhập giá tiền sản phẩm:");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ngày lên kệ:");
        String rd = scanner.nextLine();
        LocalDate releaseDate = LocalDate.parse(rd, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        switch (type) {
            case "SH":
                return new Shirt(code, name, color, brand, price, releaseDate);
            case "JA":
                System.out.println("Nhập chất liệu áo khoác:");
                String jacketFabric = scanner.nextLine();
                return new Jacket(code, name, color, brand, price, jacketFabric, releaseDate);
            case "BE":
                System.out.println("Nhập chất liệu da thắt lưng:");
                String leather = scanner.nextLine();
                return new Jacket(code, name, color, brand, price, leather, releaseDate);
            case "PA":
                return new Pant(code, name, color, brand, price, releaseDate);
            case "SP":
                System.out.print("Nhập dáng kính:");
                String shape = scanner.nextLine();
                return new Spectacles(code, name, color, brand, price, shape, releaseDate);
            case "SC":
                System.out.print("Nhập kiểu dáng khăn:");
                String design = scanner.nextLine();
                System.out.print("Nhập chất liệu khăn:");
                String scarfFabric = scanner.nextLine();
                return new Scarf(code, name, color, brand, price, design, scarfFabric, releaseDate);
            default:
                return null;
        }
    }

    private static void removeItems(Manager items) {
        System.out.println("Nhập mã sản phẩm mún xóa:");
        String code = scanner.nextLine();
        if (validate.validateCode(code)) {
            items.remove(code);
        } else {
            System.err.println("Cú pháp không hợp lệ!!!!");
            System.out.println();
        }
    }
}
