package FominaKat.NoteBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Shop {
    private Scanner scanner;
    private HashMap<String, String> filters;
    List<Laptop> laptopList;

    public Shop() {
        this.laptopList = new ArrayList<>();
        this.filters = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void initShop() {
        this.laptopList.add(new Laptop("ASUS", "B1502CGA-BQ0081", 8, 128, OS.WIN10, Color.BLACK));
        this.laptopList.add(new Laptop("ASUS", "B1502CGA-BQ0082", 8, 256, OS.WIN10, Color.WHITE));
        this.laptopList.add(new Laptop("HUAWEI", "MateBook D 14", 16, 256, OS.WIN10, Color.GRAY));
        this.laptopList.add(new Laptop("Aser", "Aspire 5", 16, 512, OS.WIN10, Color.BLACK));
    }

    public List<Laptop> choiceLaptop() {
        getMinRam();
        getMinSSD();
        getBrand();
        return laptopList.stream()
                .filter(this::toMatch).toList();


    }

    private boolean toMatch(Laptop laptop) {
        for (String key : filters.keySet()) {
            if ((key.equals("ram")) && (laptop.getRam() < Integer.parseInt(filters.get(key)))) {
                return false;
            }
            if ((key.equals("ssd")) && (laptop.getSsd() < Integer.parseInt(filters.get(key)))) {
                return false;
            }
            if ((key.equals("fabric")) && (!laptop.getFabric().equals(filters.get(key)))) {
                return false;
            }
        }
        return true;
    }

    private void getMinRam() {
        boolean entryFilter = false;
        while (!entryFilter) {
            System.out.println("укажите минимальный объем RAM (либо 0, если параметр не важен):");
            String ramTxt = this.scanner.nextLine();
            if (ramTxt.matches("[0-9]+") && ((Integer.parseInt(ramTxt) % 8) == 0)) {
                if (Integer.parseInt(ramTxt) > 0) {
                    this.filters.put("ram", ramTxt);
                }
                entryFilter = true;
            } else {
                System.out.println("некорректный ввод: укажите число, кратое 8 либо 0, если параметр не важен");
            }
        }
    }

    private void getMinSSD() {
        boolean entryFilter = false;
        while (!entryFilter) {
            System.out.println("укажите минимальный объем SSD (либо 0, если параметр не важен):");
            String ssdTxt = this.scanner.nextLine();
            if (ssdTxt.matches("[0-9]+") && ((Integer.parseInt(ssdTxt) % 8) == 0)) {
                if (Integer.parseInt(ssdTxt) > 0) {
                    this.filters.put("ssd", ssdTxt);
                }
                entryFilter = true;
            } else {
                System.out.println("некорректный ввод: укажите число, кратое 8 либо 0, если параметр не важен");
            }
        }
    }

    private void getBrand() {
        boolean choise = false;

        while (!choise) {

            System.out.println("список доступных производителей:");
            List<String> brands = listBrands();
            for (int i = 0; i < brands.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, brands.get(i));
            }

            System.out.println("укажите номер производителя (либо 0, если параметр не важен):");
            String brandTxt = this.scanner.nextLine();

            if (brandTxt.matches("[0-9]+") && (Integer.parseInt(brandTxt) <= brands.size())) {
                int numChoice = Integer.parseInt(brandTxt);
                if (numChoice > 0) {
                    this.filters.put("fabric", brands.get(numChoice - 1));
                }
                choise = true;
            } else {
                System.out.printf("некорректный ввод: укажите число от 1 до %d либо 0, если параметр не важен\n",
                        brands.size());
            }
        }
    }

    private List<String> listBrands() {
        return laptopList.stream()
                .map(e -> e.getFabric())
                .collect(Collectors.toSet())
                .stream().toList();
    }


}
