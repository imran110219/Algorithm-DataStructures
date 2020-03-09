package sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Imran on 1/24/2020.
 */
public class UnitTest {

    @Test
    public void mergeTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort.mergeSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bubbleTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        BubbleSort.bubbleSort(actual);
        assertArrayEquals(expected, actual);
    }
}
