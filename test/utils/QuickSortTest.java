/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class QuickSortTest {
    
    public QuickSortTest() {
    }

    @Test
    public void testSomeMethod() {
        int[] a = new int[]{3,2,4,1};
        int[] b = a.clone();
        Arrays.sort(a);
        QuickSort qs = new QuickSort(b);
        qs.sort();
        assertArrayEquals(a, b);
    }
}
