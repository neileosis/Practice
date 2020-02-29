package arrays;

import org.junit.Assert;
import org.junit.Test;

public class UniqueNumberSortedListTest {

    private UniqueNumberSortedList uniqueNumberSortedList = new UniqueNumberSortedList();

    @Test
    public void testCountUniqueNumbers() {
        int[] array = new int[]{1, 1, 2, 3, 4, 4, 5, 5};
        Assert.assertEquals(Integer.valueOf(5), uniqueNumberSortedList.uniqueNumbers(array));
    }

    @Test
    public void testCountUniqueNumbersOnlyOne() {
        int[] array = new int[]{1, 1, 1};
        Assert.assertEquals(Integer.valueOf(1), uniqueNumberSortedList.uniqueNumbers(array));
    }

    @Test
    public void testCountUniqueNumbersNullArray() {
        Assert.assertNull(uniqueNumberSortedList.uniqueNumbers(null));
    }

    @Test
    public void testCountUniqueNumbersEmptyArray() {
        Assert.assertNull(uniqueNumberSortedList.uniqueNumbers(new int[]{}));
    }
}
