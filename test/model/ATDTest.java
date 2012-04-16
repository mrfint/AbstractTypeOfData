package model;

import org.junit.*;
import static org.junit.Assert.*;


public class ATDTest {
    private ATD c = null;

    @Before
    public void setup(){
        c = new xList();
    }
    //******************************************** Test zero
    @Test
    public void testZeroSize(){
        assertEquals(0, c.size());
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroGetZElement(){
       c.get(0);
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroGetSecondElement(){
       c.get(1);
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroSetZElement(){
       c.set(0,10);
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroSetSecondElement(){
       c.set(1,10);
    }
  
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroAddToSecondPos(){
       c.addToPos(2,10);
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroDelFromStart(){
       c.delFromStart();
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroDelFromEnd(){
       c.delFromEnd();
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroDelFromAnyPos(){
       c.del(10);
    }
    //************************************************ One element
    @Test
    public void testOneSize(){
        c.addToStart(10);
        assertEquals(1, c.size());
    }
    @Test
    public void testOneGetZElement(){
       c.addToStart(10);
       
       assertEquals(10, c.get(0));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneGetSecondElement(){
       c.addToStart(10);
       c.get(1);
    }
    @Test
    public void testOneSetZElement(){
       c.addToStart(10);
       c.set(0,100);
       
       assertEquals(100, c.get(0));
        
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneSetSecondElement(){
       c.addToStart(10);
       c.set(2,10);
    }
  
    @Test
    public void testOneAddToStart(){
       c.addToStart(10);
       c.addToStart(20);
       
       assertEquals(20, c.get(0));
       assertEquals(10, c.get(1));
       
    }
    @Test
    public void testOneAddToEnd(){
       c.addToEnd(10);
       c.addToEnd(20);
       
       assertEquals(10, c.get(0));
       assertEquals(20, c.get(1));
       
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneAddToSomePos(){
       c.addToStart(10);
       c.addToPos(10,100);
    }
    @Test
    public void testOneDelFromStart(){
       c.addToStart(10);
       c.delFromStart();
       assertEquals(0, c.size());
    }
    @Test
    public void testOneDelFromEnd(){
       c.addToStart(10);
       c.delFromEnd();
       assertEquals(0, c.size());
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneDelFromAnyPos(){
       c.del(10);
    }
    

    @Test
    public void testAddGet() {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);
        }
        
        int[] b = new int[n];
        for (int i = 0; i < c.size(); i++) {
            b[i] = c.get(i);
        }
        assertTrue(c.equals(b));
    }
@Ignore
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
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testAddToPos() {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);        
        }
        c.addToPos(12,100);
        
        int[] b = new int[]{0, 1, 100, 2, 3, 4};

        assertTrue(c.equals(b));
    }
@Ignore
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
@Ignore    
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
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testDelPos() {
        int n = 5;
        
        for (int i = 0; i < n; i++) {
            c.addToEnd(i);        
        }
        c.del(12);
        
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
