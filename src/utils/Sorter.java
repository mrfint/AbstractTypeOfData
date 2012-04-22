
package utils;

public abstract class Sorter implements Runnable{
    protected final int DELAY = 100;
    protected int[] a;

    public Sorter(int[] a) {
        this.a = a;
    }
    
}
