package FominaKat;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        Map <People, Integer> map = new HashMap<>();

        map.put(new People("first", "last"), 15);
        map.put(new People("first", "last"), 16);

        for (Map.Entry<People, Integer> item : map.entrySet()){
            System.out.printf("%d - %s, %d\n", item.getKey().hashCode(), item.getKey().toString(), item.getValue());
        }

    }
}
