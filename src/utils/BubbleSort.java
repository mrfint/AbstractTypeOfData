
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainFrame;

public class BubbleSort extends Sorter{
    private MainFrame mf = null;

    public BubbleSort(int[] a) {
        super(a);
    }
    public BubbleSort(int[] a, MainFrame mf) {
        super(a);
        this.mf = mf;
    }
    
    @Override
    public void run() {
        int c;
        for (int i = 0; i < a.length; i++) 
        {   
            try 
            {
                for (int j = i+1; j < a.length; j++){
                    if(a[i]>a[j]) {  c=a[i];  a[i]=a[j];   a[j]=c;  }
                }
                if(mf!=null) mf.refreshMass();
                Thread.sleep(DELAY);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
