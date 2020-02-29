package arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstElementKTimesTest {

    private FirstElementKTimes firstElementKTimes;
    private int[] array;

    @Before
    public void setup() {
        firstElementKTimes = new FirstElementKTimes();
        array = new int[]{1, 7, 4, 3, 4, 8, 7};
    }

    @Test
    public void testWithCorrectNumberChosen() {
        int k = 2;
        Assert.assertEquals(4, firstElementKTimes.firstElement(array, k));
    }

    @Test
    public void testNullArrayInput() {
        Assert.assertEquals(-1, firstElementKTimes.firstElement(null, 2));
    }

    @Test
    public void testEmptyArrayInput() {
        Assert.assertEquals(-1, firstElementKTimes.firstElement(new int[]{}, 2));
    }

    @Test
    public void testInvalidKInput() {
        Assert.assertEquals(-1, firstElementKTimes.firstElement(null, -1));
    }

    @Test
    public void testWithNoNumberChosen() {
        int k = 3;
        Assert.assertEquals(-1, firstElementKTimes.firstElement(array, k));
    }

}
