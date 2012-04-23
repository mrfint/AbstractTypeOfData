
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.xPanel;

public abstract class Sorter implements Runnable{
    protected final int DELAY = 10;
    protected int[] a;
    protected xPanel xpan;
    
    public Sorter(int[] a) {
        this.a = a;
    }
    public Sorter(xPanel xpan) {
        a = xpan.getMass();
        this.xpan = xpan;
    }
    
    @Override
    public void run() {
        sort();
    }
    
    public abstract void sort();
    
    protected void swap(int i, int j) {
         int c=a[i];  
         a[i]=a[j];   
         a[j]=c; 
         
        if(xpan!=null){
            xpan.refresh();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
