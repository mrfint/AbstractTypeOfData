
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainFrame;
import view.xPanel;

public class BubbleSort extends Sorter{

    public BubbleSort(int[] a) {
        super(a);
    }
    public BubbleSort(xPanel xpan) {
        super(xpan);
    }
    
    @Override
    public void sort() {       
        for (int i = 0; i < a.length; i++) 
        {   
                for (int j = i+1; j < a.length; j++){
                    if(a[i]>a[j]) {  
                       swap(i,j);
                    }
                }
        }
    }

}
