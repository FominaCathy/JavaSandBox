package FominaKat.HeapSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};

        SortArray.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
