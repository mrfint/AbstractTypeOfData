
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainFrame;
import view.xPanel;

public class QuickSort extends Sorter{
    private xPanel xpan = null;

    public QuickSort(int[] a) {
        super(a);
    }
    public QuickSort(xPanel xpan) {
        super(xpan.getMass());
        this.xpan = xpan;
    }
    
    @Override
    public void run() {
        qs(a, 0, a.length-1);
    }
    public void sort() {
        qs(a, 0, a.length-1);
    }

    private void qs(int[] items, int left, int right) {
        int i, j;
        int x, y;
        
        i = left;  j = right;
        x = items[(left + right)/2];
        
        do {
                while( (items[i] < x ) && (i < right)) i++;
                while( (x < items[j] ) && (j > left)) j--;

                    if (i <= j) {
                        y = items[i];
                        items[i] = items[j];
                        items[j] = y;
                        i++; j--;
                        if(xpan!=null)
                        {
                            xpan.refresh();
                            try {
                                Thread.sleep(DELAY);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(HeapSort.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
        } while (i <= j);
        
        if(left < j)  qs(items, left, j);
        if(i < right) qs(items, i, right);
    }
    
}
