/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.*;
import static org.junit.Assert.*;


public class FlowArrayListTest {
    private OneWayLinkedList c =null;
    private int[] b;

    @Before
    public void setUp() throws InstantiationException, IllegalAccessException{
        
        c = new OneWayLinkedList();
       
        b = new int[]{0, 1, 2, 3, 4};
    }
    @After
    public void tearDown(){
        c = null;
        b = null;
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
  //////////
    
    @Test
    public void testOneAddToStart(){
       c.addToStart(10);
       c.addToStart(20);
       c.toString();
       assertEquals(20, c.get(0));
       assertEquals(10, c.get(1));
       
    }
    @Test
    public void testOneAddToEnd(){
       c.addToEnd(10);
       c.addToEnd(20);
       c.toString();
       assertEquals(10, c.get(0));
       assertEquals(20, c.get(1));
       
    }
    /////////////
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


    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneDelFromAnyPos(){
       c.del(10);
    }
    
    @Test
    public void testOneDelFromEnd(){
       c.addToStart(10);
       c.delFromEnd();
       assertEquals(0, c.size());
    }
}
