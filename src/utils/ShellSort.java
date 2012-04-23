
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainFrame;
import view.xPanel;

public class ShellSort extends Sorter{
    private xPanel xpan = null;

    public ShellSort(int[] a) {
        super(a);
    }
    public ShellSort(xPanel xpan) {
        super(xpan.getMass());
        this.xpan = xpan;
    }
    
    @Override
    public void sort() {
        int i, j, k, h, m=0, b=a.length;
        int[] d =  { 1, 4, 10, 23, 57, 145 };
        while (d[m] < b) ++m;
        while (--m >= 0){
            k = d[m];
            for (i=k; i<b; i++){     // k-сортировка
                j=i;
                h=a[i];
                while ((j >= k) && (a[j-k] > h)){  
                    a[j]=a[j-k];
                    j =  j-k;
                }
                a[j] = h;
                if(xpan!=null){
                    xpan.refresh();
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ShellSort.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }            
        }
    }
    
}
