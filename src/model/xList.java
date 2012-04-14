
package model;

public class xList extends ATD{
    private int n = 100;
    private final int K = 20; // grow persent
    
    private int[] a = new int[n];
    
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
        if( count == (n-1) )  upBorderOfArray();
        
        for (int i = count; i > 0 ; i--) {
            a[i] = a[i-1];
        }
        a[0] = x;
        
        count++;
    }
    @Override
    public void delFromStart() {
        
        for (int i = 1; i < count ; i++) {
            a[i-1] = a[i];
        }
                
        count--;
    }

    @Override
    public void add(int x) {
        if( count == (n-1) ) upBorderOfArray();
        a[count] = x ;
        count++;
    }

    @Override
    public void add(int pos, int x) {
        if( count == (n-1) )  upBorderOfArray();
        
        for (int i = count; i > pos ; i--) {
            a[i] = a[i-1];
        }
        a[pos] = x;
        count++;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        a = new int[100];
    }

    @Override
    public void set(int pos, int x) {
        a[pos] = x;
    }

    @Override
    public int get(int pos) {
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
        for (int i = 0; i < count-1 ; i++) 
        {   for (int j = i+1; j < count; j++){
                if(a[i] > a[j]) {  int c = a[i];  a[i] = a[j];   a[j] = c;  }
            }
        }

    }
    
    public boolean equals(Object ob){
        boolean res = true;
        int[] o = (int[])ob;
        if(count!=o.length) return false;
        for (int i = 0; i < count; i++) {
            if(a[i]!=o[i]) { res = false;  break; }
        }
        return res;
    }

    @Override
    public void delFromEnd() {
        a[count] = 0;
        count--;
    }

    @Override
    public void del(int pos) {
        for (int i = pos; i < count ; i++) {
            a[i] = a[i+1];
        }
        count--;
    }


}
