/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;


public class FlowArrayListTest {
    
    
    @Test
    public void testSomeMethod() {
        FlowArrayList c = new FlowArrayList();
        //c.setArray(new int[]{1, 1, 1, 1, 1});
        System.out.println(""+c.toString());
        for (int i = 0; i < 110; i++) {
            c.addToEnd(i);
        }
        System.out.println(""+c.toString());
    }
}
