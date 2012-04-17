/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


public class FlowArrayListTest {
    
    

    @Test
    public void testSomeMethod() {
        FlowArrayList c = new FlowArrayList();
        c.setArray(new int[]{5, 1, 2, 3, 4});
        System.out.println(""+c.toString());
    }
}
