
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainFrame;
import view.xPanel;

public class InsertSort extends Sorter{

    public InsertSort(int[] a) {
        super(a);
    }
    public InsertSort(xPanel xpan) {
        super(xpan);

    }
    
    @Override
    public void sort() {
        int min;
        for(int i=0; i<a.length-1; i++){
            min=i;
            for(int j=i+1; j<a.length; j++){
                if( a[j]< a[min])      min=j;
            }
            if (min!=i) {  
                swap(i,min);
            }             
        }
    }

}
