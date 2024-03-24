package FominaKat.NoteBook;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop();
        shop.initShop();

        //получить список по параметрам.
        List<Laptop> choice = shop.choiceLaptop();
        //печать листа ноутбуков
        choice.forEach(System.out::println);
    }
}
