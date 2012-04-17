
package model;


public class OneWayLinkedList implements 
                                        ATD{
    private Node ndFace = null;
    private int length = 0;
    
    @Override
    public void addToStart(int x) {
        Node newnd  = new Node(x);
        newnd.setNext(ndFace);
        ndFace = newnd;

        length++;
    }

    @Override
    public void addToEnd(int x) {
        Node newnd = new Node(x);
        if (ndFace==null) {
                ndFace = newnd;        
        }
        else {
                Node next = ndFace;

                while (next.getNext() != null) {
                        next = next.getNext();
                }
                next.setNext(newnd);
        }
        
        length++;
    }

    @Override
    public void addToPos(int pos, int x) {
        Node newnd = new Node(x);
        if (pos == 0){
                newnd.setNext(ndFace);
                ndFace = newnd;
        }
        else{
                Node prev = getNodeByPos(pos-1); 
                newnd.setNext(prev.getNext());
                prev.setNext(newnd);
        }

        length++;
    }

    @Override
    public void delFromStart() {
        if ( ndFace == null){   throw new ArrayIndexOutOfBoundsException();      }
        ndFace = getNextNode(ndFace);
        length--;
    }

    @Override
    public void delFromEnd() {
        if ( ndFace == null){   throw new ArrayIndexOutOfBoundsException();      }
        
        if (ndFace.getNext() == null) {
                ndFace = null;
        } else {
                Node prev = ndFace;

                while (getNextNode(prev) != null) {
                        prev = prev.getNext();
                }
                prev.setNext(null);
        }
        length--;
    }

    @Override
    public void del(int pos) {
        
        if (pos == 0){
                ndFace = ndFace.getNext();
        }
        else{
                Node prev = getNodeByPos(pos-1); 
                prev.setNext(getNextNode(getNextNode(prev)));
        }

        length--;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void clear() {
        ndFace = null;
        length = 0;
    }

    @Override
    public void set(int pos, int x) {
         if(pos >= length || pos < 0) throw new ArrayIndexOutOfBoundsException();
        Node current = getNodeByPos(pos);
	current.setData(x);
    }

    @Override
    public int get(int pos) {
        if(pos >= length) throw new ArrayIndexOutOfBoundsException();
        return getNodeByPos(pos).getData();
    }

    @Override
    public int find(int x) {
        int res = -1;
       
        Node next = ndFace;
        for (int i = 0; i < length; i++) {
            if(next.getData()==x) { res = i;  break; } 
            next = next.getNext();
        }

        return res;
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setArray(int[] a) {
        Node prevNode = new Node(a[0]);
        length++;
        ndFace = prevNode;
        for (int i = 1; i < a.length; i++){
                Node newNode = new Node(a[i]);
                length++;
                prevNode.setNext(newNode);
                prevNode = newNode;
        }
    }
    
    public String toString(){
        if(ndFace==null) return "";
       
        Node next = ndFace;
        for (int i = 0; i < length; i++) {
            System.out.print(" "+next.getData());
            next = next.getNext();
        }

        return "";
    }
    
    public boolean equals(Object ob){
        boolean res = true;
        int[] o = (int[])ob;
        if(length!=o.length) return false;
        
        if(ndFace==null) return false;
       
        Node next = ndFace;
        for (int i = 0; i < length; i++) {
            if(next.getData()!=o[i]) {
                res = false;
                break;
            }
            next = next.getNext();
        }
        return res;
    } 
    
    private Node getNextNode(Node currNode) {
        Node res = null;
        if (currNode != null){
                res = currNode.getNext();
        }
        return res;
    }
	
    private Node getNodeByPos(int pos) {
            Node res = ndFace;	

            int i = 0;
            while (res != null) 
            {
                    if (i == pos) {		break;			}
                    res = res.getNext();
                    i++;
            }

            if (i < pos || res == null) {
                    throw new ArrayIndexOutOfBoundsException();
            }

            return res;
    }


}
        class Node{
            
            private int data;
            private Node next;

            public Node(int data) {
                this.data = data;
            }

            public Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }


            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }


        }