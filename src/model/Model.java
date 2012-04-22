
package model;

public class Model {
    private int n = 20;
    private int h = 10;
    private int[] a = null;

    public Model() {
        initMass();
    }
    
    
    public void initMass(){
        a = new int[n];
        for(int i=0; i<n; i++) a[i]=(int) (Math.random()*h);
    }
    public int[] getMass(){
        return a;
    }

    public int getH() {
        return h;
    }
}
