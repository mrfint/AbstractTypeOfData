
package model;

public class Model {
    private final int nSORTERS = 7;
    private int n = 20;
    private int h = 10;
    private int[][] a = null;

    public Model() {
        initMass();
    }
    
    
    public void initMass(){
        int[] tmp = new int[n];
        for(int j=0; j<n; j++) tmp[j]=(int) (Math.random()*h);
        
        a = new int[nSORTERS][n];
        for (int i = 0; i < nSORTERS; i++) {
            a[i] = tmp.clone();
        }      
        
    }
    public int[] getMass(int type){
        return a[type];
    }

    public int getH() {
        return h;
    }
}
