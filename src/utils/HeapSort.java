
package utils;

public class HeapSort
 {
    public HeapSort(int[] anArray)
    {
       a = anArray;
    }

    public void sort()
    {
       sort( a.length - 1 );
    }
 
    public void sort( int end )
   {
       for ( int i = end / 2; i >= 1; i-- )         fixHeap( i, end, a[i] );
       
       for ( int i = end; i > 1; i-- )
       {
          swap( 1, i );
 
          fixHeap( 1, i - 1, a[1] );
       }
    }

    private void fixHeap( int root, int end,
                          int key )
    {
       int child = 2 * root;      // left child
       
       if ( child < end && a[child] < a[child + 1] )
          child++;               // right child is larger

       if ( child <= end && key < a[child] )
       {
          a[root] = a[child];
          fixHeap( child, end, key );
       }
       else
          a[root] = key;
    }
 
   private void swap(int i, int j)
    {
       int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
 
    private int[] a;
 }
