
package model;

public class FlowArrayList implements ATD{
    private int n = 99;
    private int countLeft  = n/2+1;
    private int countRight = n/2;
    
    
    private int[] a = new int[n];

    public FlowArrayList() {
    }

    
    public FlowArrayList(int[] x) {
        if(x.length > n  ) {   n = x.length; }
        countLeft = x.length-1;
        for (int i = 0; i < x.length; i++){
                a[i] = x[i];
        }
        }
    
    
    
    private void upBorderOfArray(){
        int nn = (int) (n*1.2);
        int[] b = new int[nn];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        a = b;
        n = nn;
    }
    
    @Override
    public void addToStart(int x) {
        if((countLeft-1)==0) upBorderOfArray();
        countLeft--;
        a[countLeft] = x;
    }
    

    @Override
    public void addToEnd(int x) {
        if((countRight+1)==n-1) upBorderOfArray();
        countRight++;
        a[countRight] = x;
    }

    @Override
    public void addToPos(int pos, int x) { 
        if ( ( (countRight+1)==(n-1)) || ((countLeft-1)==0) ) upBorderOfArray();
        if ( (pos > (countRight + 1)) || (pos < (countLeft -1 )) ) {
            throw new ArrayIndexOutOfBoundsException();
        }
        /*
        count++;
        if( count == (n-1) )  upBorderOfArray();
        
        for (int i = count; i > pos ; i--) {
            a[i] = a[i-1];
        }
        a[pos] = x;
        */
    }

    @Override
    public int size() {
        return countRight-countLeft+1;
    }

    @Override
    public void clear() {
        a = new int[100];
    }

    @Override
    public void set(int pos, int x) {
        if ( (pos > (countRight + 1)) || (pos < (countLeft -1 )) ) {
            throw new ArrayIndexOutOfBoundsException();   
        }
        a[pos] = x;
    }

    @Override
    public int get(int pos) {
        if ( (pos > (countRight + 1)) || (pos < (countLeft -1 )) ) {
            throw new ArrayIndexOutOfBoundsException();   
        }
        return a[pos];
    }

    @Override
    public int find(int x) {
        int res = -1;
        for (int i = 0; i < size(); i++) {
            if(a[i]==x) { 
                res = i; 
                break;
            } 
        }
    return res;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size()-1 ; i++) 
        {   for (int j = i+1; j < size(); j++){
                if(a[i] > a[j]) {  int c = a[i];  a[i] = a[j];   a[j] = c;  }
            }
        }

    }
    
    public boolean equals(Object ob){
        boolean res = true;
        int[] o = (int[])ob;
        if(size()!=o.length) return false;
        for (int i = 0; i < size(); i++) {
            if(a[i]!=o[i]) { res = false;  break; }
        }
        return res;
    }

    @Override
    public void delFromEnd() {
        del(countRight);
    }
    
    @Override
    public void delFromStart() {
        del(countLeft);
    }

    @Override
    public void del(int pos) {
        if ( (pos >=size()) || (pos < 0) ) {
            throw new ArrayIndexOutOfBoundsException();  
        }
        
        if (pos <= size()/2) {
            for (int i = pos; i >= countLeft ; i--) {
                a[i] = a[i-1];
            }
            countLeft--;
        }
        else
        {
           for (int i = pos; i <= countRight ; i++) {
            a[i] = a[i+1];
            }
           countRight--;
        }

    }

    @Override
    public void setArray(int[] x) {
        if(x.length > n  ) {   n = x.length; a = new int[x.length]; }
        
        for (int i = x.length/2; i >= 0; i--){
            countLeft--;    
            a[countLeft] = x[i];
        }
        for (int i = x.length/2+1; i < x.length; i++){
            countRight++;    
            a[countRight] = x[i];
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
