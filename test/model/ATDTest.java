package model;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;


public class ATDTest {
    private ATD c = null;

    @Before
    public void setup(){
        c = new xList();
    }
    
    @Test
    public void testAddGet() {
        int n = 110;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);
        }
        
        int[] b = new int[n];
        for (int i = 0; i < c.size(); i++) {
            b[i] = c.get(i);
        }
        assertTrue(c.equals(b));
    }
    @Test
    public void testAddToStart() {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);        
        }
        c.addToStart(100);
        
        int[] b = new int[]{100, 0, 1, 2, 3, 4};

        assertTrue(c.equals(b));
    }
    @Test
    public void testAddToPos() {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);        
        }
        c.addToPos(2,100);
        
        int[] b = new int[]{0, 1, 100, 2, 3, 4};

        assertTrue(c.equals(b));
    }
    @Test
    public void testDelFromStart() {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);        
        }
        c.delFromStart();
        
        int[] b = new int[]{1, 2, 3, 4};

        assertTrue(c.equals(b));
    }
    
    @Test
    public void testDelFromEnd() {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);        
        }
        c.delFromEnd();
        
        int[] b = new int[]{0, 1, 2, 3};

        assertTrue(c.equals(b));
    }
    
    @Test
    public void testDelPos() {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);        
        }
        c.del(2);
        
        int[] b = new int[]{0, 1, 3, 4};

        assertTrue(c.equals(b));
    }
    
    @Test
    public void sort() {
        int n = 5;
        
        for (int i = n-1; i >= 0; i--) {
            c.addToEnd(i);  
        }
        c.sort();

        int[] b = new int[]{0, 1, 2, 3, 4};

        assertTrue(c.equals(b));
    }
    
    @Test
    public void find() {
        int n = 5;
        
        for (int i = n-1; i >= 0; i--) {
            c.addToEnd(i);  
        }

       assertEquals(0,  c.find(4));
    }
}
