
package utils;

import model.Model;
import view.MainFrame;
import view.xPanel;

public class FactorySorter {
        private Sorter[] arr = null;

        public Sorter getInstance(xPanel xpan)
        {   
            arr = new Sorter[7];
            switch(xpan.getType()){
                case 0 :  arr[0] = new BubbleSort(xpan);        break;
                case 1 :  arr[1] = new InsertSort(xpan);        break;
                case 2 :  arr[2] = new SelectionSort(xpan);     break;
                case 3 :  arr[3] = new ShellSort(xpan);         break;
                case 4 :  arr[4] = new QuickSort(xpan);         break;
                case 5 :  arr[5] = new MergeSort(xpan);         break;
                case 6 :  arr[6] = new HeapSort(xpan);          break;
            }

            return arr[xpan.getType()];
            
        }


    
}
