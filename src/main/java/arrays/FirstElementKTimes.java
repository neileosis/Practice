package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n integers. The task is to find the first element that occurs k number of times. 
 * If no element occurs k times the print -1. The distribution of integer elements could be in any range.
 * https://www.geeksforgeeks.org/first-element-occurring-k-times-array/
 */
public class FirstElementKTimes {

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 4, 3, 4, 8, 7};
        int k = 2;
        System.out.println(firstElement(array, k));
    }

    private static int firstElement(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return -1;
        else if (k == 1)
            return arr[0];

        Map<Integer,Integer> map = new HashMap<>();

        for(int element: arr) {

            Integer mapOccurrences = map.get(element);

            if (mapOccurrences == null) {
                map.put(element, 1);
            } else if ((mapOccurrences + 1) == k) {
                return element;
            } else {
                map.put(element, mapOccurrences+1);
            }
        }
        return -1;
    }
}
