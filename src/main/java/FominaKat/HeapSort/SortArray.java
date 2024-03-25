package FominaKat.HeapSort;

public class SortArray {

    public static void heapSort(int[] sortArray) {
        for (int i = sortArray.length; i > 0; i--) {
            heapify(sortArray, i, 0);
            int temp = sortArray[0];
            sortArray[0] = sortArray[i - 1];
            sortArray[i - 1] = temp;
        }
    }

    private static void heapify(int[] tree, int sortLength, int largest) {
        for (int i = sortLength / 2 - 1; i >= largest; i--) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int max = i;

            if (right < sortLength) {
                if ((tree[left] > tree[i]) && (tree[left] >= tree[right])) {
                    max = left;
                } else if ((tree[right] > tree[i]) && (tree[right] > tree[left])) {
                    max = right;
                }
            } else if ((left < sortLength) && (tree[left] > tree[i])) {
                max = left;
            }
            if (max != i) {
                int temp = tree[i];
                tree[i] = tree[max];
                tree[max] = temp;
                heapify(tree, sortLength, max);
            }
        }
    }
}