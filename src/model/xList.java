
package model;

public class xList implements ATD{
    private int count = -1;
    private int n = 100;
    
    private int[] a = new int[n];

    public xList() {
    }

    
    public xList(int[] x) {
        if(x.length > n  ) {   n = x.length; }
        count = x.length-1;
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
        addToPos(0, x);
    }
    

    @Override
    public void addToEnd(int x) {
        addToPos(count+1, x);
    }

    @Override
    public void addToPos(int pos, int x) {
        if (pos > count+1 || pos < 0 ) {       throw new ArrayIndexOutOfBoundsException();   }
        count++;
        if( count == (n-1) )  upBorderOfArray();
        
        for (int i = count; i > pos ; i--) {
            a[i] = a[i-1];
        }
        a[pos] = x;
        
    }

    @Override
    public int size() {
        return count+1;
    }

    @Override
    public void clear() {
        a = new int[100];
    }

    @Override
    public void set(int pos, int x) {
        if (pos > count) {       throw new ArrayIndexOutOfBoundsException();   }
        a[pos] = x;
    }

    @Override
    public int get(int pos) {
        if (pos > count) {       throw new ArrayIndexOutOfBoundsException();   }
        return a[pos];
    }

    @Override
    public int find(int x) {
        int res = -1;
        for (int i = 0; i < count; i++) {
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
        del(count);
    }
    
    @Override
    public void delFromStart() {
        del(0);
    }

    @Override
    public void del(int pos) {
        if ((pos > count) || (pos < 0) ) {
            throw new ArrayIndexOutOfBoundsException();  
        }
        
        for (int i = pos; i < count ; i++) {
            a[i] = a[i+1];
        }
        count--;
    }


}
