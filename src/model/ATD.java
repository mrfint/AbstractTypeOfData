
package model;

abstract public class ATD {
    protected int count = 0;
    
    abstract public void addToStart(int x);
    abstract public void add(int x);
    abstract public void add(int pos, int x);
    abstract public void delFromStart();
    abstract public void delFromEnd();
    abstract public void del(int pos);
    abstract public int  size();
    abstract public void clear();
    abstract public void set(int pos, int x);
    abstract public int  get(int pos);
    abstract public int  find(int x);
    abstract public void sort();

    
    
}
