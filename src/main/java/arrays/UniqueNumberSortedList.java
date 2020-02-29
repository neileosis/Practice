package arrays;

public class UniqueNumberSortedList {

    public Integer uniqueNumbers(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        else if (arr.length == 1)
            return 1;

        int counter = 1;
        int trackingNumber = arr[0];
        for(int num=1; num<arr.length; num++) {
            if (arr[num] != trackingNumber) {
                trackingNumber = arr[num];
                counter+=1;
            }
        }
        return counter;
    }
}
