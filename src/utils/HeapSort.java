
package utils;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.xPanel;

public class HeapSort extends Sorter {
    public HeapSort(int[] a) {
       super(a);
    }
    public HeapSort(xPanel xpan) {
        super(xpan);
    }

    @Override
    public void sort() {
       mergeSort( a.length - 1 );
    }
 
    private void mergeSort( int end )
    {
        int l = a.length;
        if (l == 0){
           return;
        }

        rearrange(a, l);

        while(l > 1){
                swap( 0,l-1);
                l--;
                rearrange(a, l);
        }
        
    }

    private void rearrange(int a[], int to){
        int mid = to/2-1;   int c;
        for (int i = mid; i >=0; i--){

                int top =  a[i];
                int el1 =  a[i*2];
                int el2 =  a[i*2+1];

                if (el2 > el1){ //el2 is bigger than el1
                        if (top<el2){                                
                                swap(i, i*2+1);
                        }
                }else{
                        if (top<el1){
                                swap(i, i*2);
                        }
                }
        }
    }
    
 }
