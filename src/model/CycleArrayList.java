
package model;

public class CycleArrayList implements ATD{
    private int n = 10;
    private int countLeft  = n-1;
    private int countRight = 0;
    
    
    private int[] a = new int[n];

    private void upBorderOfArray(){
        int s = size();
        int[] b = new int[size()];
        
        for (int i = countLeft; i < countLeft+size(); i++) {
            b[i-countLeft] = a[i];
        }
        
        n = (int) (n*1.2);
        a = new int[n];
        setArray(b);
    }
    
    @Override
    public void addToStart(int x) {
        if ( countLeft == countRight ) {
            upBorderOfArray();     
        }
        a[countLeft] = x;
        if(countLeft-1 == -1) countLeft = n-1;
        else {        countLeft--;          }
        
    }
    

    @Override
    public void addToEnd(int x) {
        if ( countRight == countLeft ) {
            upBorderOfArray();     
        }
        a[countRight] = x;
        if(countRight+1 == n) countRight = 0;
        else{        countRight++;          }
        
    }

    @Override
    public void addToPos(int pos, int x) { 
        if ( (pos >size()) || (pos < 0) ) {
            throw new ArrayIndexOutOfBoundsException();  
        }
        if ( countRight == countLeft ) {
            upBorderOfArray();     
        }
        if( (countLeft+pos)==0 || (countLeft+pos)==n-1 ) upBorderOfArray();
        if (pos <= size()/2) {
            for (int i = countLeft-1; i < countLeft+pos ; i++) {
                a[i] = a[i+1];
            }
            countLeft--;
        }
        else
        {
           for (int i = countRight+1; i > countLeft+pos ; i--) {
            a[i] = a[i-1];
            }
           countRight++;
        }
        a[countLeft+pos] = x;
    }

    @Override
    public int size() {
        return n-Math.abs(countRight-countLeft)-1;
    }

    @Override
    public void clear() {
        a = new int[100];
    }

    @Override
    public void set(int pos, int x) {
        if ( (pos >=size()) || (pos < 0) ) {
            throw new ArrayIndexOutOfBoundsException();   
        }
        int indx = ((countLeft+1+pos) >= n)? (countLeft+1+pos)%n : countLeft+1+pos;
        a[indx] = x;
    }

    @Override
    public int get(int pos) {
        
        if ( (pos >=size()) || (pos < 0) ) {
            throw new ArrayIndexOutOfBoundsException();   
        }
        int indx = ((countLeft+1+pos) >= n)? (countLeft+1+pos)%n : countLeft+1+pos;
        return a[indx];
    }

    @Override
    public int find(int x) {
        int res = -1;
        for (int i = countLeft; i < countLeft+size(); i++) {
            if(a[i]==x) { 
                res = i - countLeft; 
                break;
            } 
        }
    return res;
    }

    @Override
    public void sort() {
        for (int i = countLeft; i < size()-1 ; i++) 
        {   for (int j = i+1; j < size(); j++){
                if(a[i] > a[j]) {  int c = a[i];  a[i] = a[j];   a[j] = c;  }
            }
        }

    }
    
    public boolean equals(Object ob){
        boolean res = true;
        int[] o = (int[])ob;
        if(size()!=o.length) return false;
        for (int i = countLeft+1; i < size(); i++) {
            if(a[i]!=o[i-countLeft]) { res = false;  break; }
        }
        return res;
    }

    @Override
    public void delFromEnd() {
        del(size()-1);
    }
    
    @Override
    public void delFromStart() {
        del(0);
    }

    @Override
    public void del(int pos) {
        if ( (pos >=size()) || (pos < 0) ) {
            throw new ArrayIndexOutOfBoundsException();  
        }
        
        if (pos <= size()/2) {
            for (int i = countLeft+pos; i >= countLeft ; i--) {
                a[i] = a[i-1];
            }
            countLeft++;
        }
        else
        {
           for (int i = countLeft+pos; i <= countRight ; i++) {
            a[i] = a[i+1];
            }
           countRight--;
        }

    }

    @Override
    public void setArray(int[] x) {
        if(x.length > n  ) {   n = x.length; a = new int[x.length]; }
        countLeft  = n-1;
        countRight = 0;
        
        for (int i = 0; i < x.length; i++) {
            a[countRight] = x[i];
            countRight++;
        }
    }
    @Override
    public String toString(){ 
        String res="";
        for (int i = 0; i < n; i++) {
            System.out.print(" "+a[i]);
        }
        return res;
    }

}