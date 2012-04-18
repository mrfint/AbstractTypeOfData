/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.*;
import static org.junit.Assert.*;


public class FlowArrayListTest {
    private CycleArrayList c =null;
    private int[] b;

    @Before
    public void setUp() throws InstantiationException, IllegalAccessException{
        
        c = new CycleArrayList();
       
        b = new int[]{0, 1, 2, 3, 4};
    }
    @After
    public void tearDown(){
        c = null;
        b = null;
    }
    
     @Test
    public void testManySize(){
        c.setArray(b);
        assertEquals(b.length, c.size());
    }
}
