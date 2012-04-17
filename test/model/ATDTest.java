package model;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value=Parameterized.class)
public class ATDTest {
    private ATD inst = null;
    private ATD c = null;
    private int[] b;

    public ATDTest(ATD inst) {
        this.inst = inst;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> generateData()
    {
        Object[][] data = new Object[][] {
                        { new SimpleArrayList() }, 
                        { new FlowArrayList() },
                        { new CycleArrayList() },
                        { new OneWayLinkedList() },
       };
    return Arrays.asList(data);
    }

    
    @Before
    public void setUp() throws InstantiationException, IllegalAccessException{
        
        c = inst.getClass().newInstance();
       
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
   //********************************************** Test Many 
    @Test
    public void testManySize(){
        c.setArray(b);
        assertEquals(b.length, c.size());
    }
    @Test
    public void testMenyGetZElement(){
       c.setArray(b);
       
       assertEquals(b[0], c.get(0));
    }
    @Test
    public void testMenyGetSecondElement(){
       c.setArray(b);
       assertEquals(b[1], c.get(1));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testMenyGetSomeIlligElement(){
       c.setArray(b);
       c.get(90);
    }
    @Test
    public void testMenySetZElement(){
       c.setArray(b);
       c.set(0,100);
       b[0] = 100;
       assertTrue(c.equals(b));
        
    }
    @Test
    public void testManySetSecondElement(){
       c.setArray(b);
       c.set(1,100);
       b[1] = 100;
       assertTrue(c.equals(b));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testMenySetSomeIlligElement(){
       c.setArray(b);
       c.set(90,10);
    }
    
    @Test
    public void testManyAddToStart(){
       c.setArray(b);
       c.addToStart(10);
       b = new int[]{10, 0, 1, 2, 3, 4};
       
       assertTrue(c.equals(b));
       
    }
    @Test
    public void testManyAddToEnd(){
       c.setArray(b);
       c.addToEnd(10);
       b = new int[]{0, 1, 2, 3, 4, 10};
       
       assertTrue(c.equals(b));
       
       
    }
    @Test
    public void testManyAddToSomePos(){
       c.setArray(b);
       c.addToPos(2,10);
       b = new int[]{0, 1, 10, 2, 3, 4};
       
       assertTrue(c.equals(b));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testManyAddToSomeIlligPos(){
       c.setArray(b);
       c.addToPos(90,10);
    }
    @Test
    public void testManyDelFromStart(){
       c.setArray(new int[]{10, 0, 1, 2, 3, 4});
       c.delFromStart();
       assertTrue(c.equals(b));
    }
    @Test
    public void testManyDelFromEnd(){
       c.setArray(new int[]{0, 1, 2, 3, 4, 10});
       c.delFromEnd();
       assertTrue(c.equals(b));
    }

    @Test
    public void testManyDelFromAnyPos(){
       c.setArray(new int[]{0, 1, 10, 2, 3, 4});
       c.del(2);
       assertTrue(c.equals(b));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testManyDelFromAnyIllPos(){
        c.setArray(b);
        c.del(90);
    }
    @Test
    public void testManyEquals() {
        
        c.setArray(b);
        assertTrue(c.equals(b));
    }
    
    @Test
    public void sort() {
        int n = 5;
        
        for (int i = n-1; i >= 0; i--) {
            c.addToEnd(i);  
        }
        c.sort();

        assertTrue(c.equals(b));
    }
    
    @Test
    public void find() {
       c.setArray(b);

       assertEquals(4,  c.find(4));
    }
}
