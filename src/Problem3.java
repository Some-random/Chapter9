import CtCILibrary.CtCILibrary.AssortedMethods;

import java.util.Arrays;

/**
 * Created by Bob_JIANG on 8/18/2015.
 */
public class Problem3 {
    public static int magicFast(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid){
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    /* Creates an array that is distinct and sorted */
    public static int[] getDistinctSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) {
                array[i]++;
            } else if (array[i] < array[i - 1]) {
                array[i] = array[i-1] + 1;
            }
        }
        return array;
    }

    //Just normal stuff, binary search if no duplicates, worst case O(n) time if has duplicates
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int size = AssortedMethods.randomIntInRange(5, 20);
            int[] array = getDistinctSortedArray(size);
            int v2 = magicFast(array);
        }
    }
}
