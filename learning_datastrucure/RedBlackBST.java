package learning_datastrucure;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private Node root;
    public final static boolean RED = true, BLACK = false;

    
      public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {

        if (x == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = put(x.left, key, value);
            x.count++;
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
            x.count++;
        } else {
            x.value = value;
        }

        if (!isRed(x.left) && isRed(x.right)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColor(x);
        }

        return x;
    }

    
    
    private Node rotateLeft(Node h) {
        Node x = h.right;
        int xM1 = size(x.left) , xT = size(x) ;
        h.count = (h.count-xT) + xM1 ;
        x.count = (x.count-xM1) + h.count ;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
       
        return x;

    }

     private Node rotateRight(Node h) {
        Node x = h.left;
        int xM2 = size(x.right) , xT = size(x) ;
        h.count = (h.count-xT) + xM2 ;
        x.count = (x.count-xM2) + h.count ;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    
    private void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

   

    private Node getNode(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return null;

    }

    public Value getValueOf(Key key) {
        Node temp = getNode(key) ; 
        return  temp== null ? null : temp.value ;
    }
    
    public boolean contains(Key key){
        return getNode(key)!=null ; 
    }
    
    
    
    
  
    public Key getMax() {
        Node temp = root;

        while (temp.right != null) {
            temp = temp.right;
        }

        return temp.key;

    }

    private boolean isRed(Node n) {
        if (n == null) {
            return false;
        }
        return n.color == RED;
    }

    public Key getMin() {
        Node temp = root;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp.key;
    }
    private Node getMin(Node r){
        while (r.left != null) {
            r = r.left;
        }
        return r ; 
    }
    
     public ArrayList<Key> elementsBtweenKeys(Key start , Key end ){
        
        ArrayList<Key>result = new ArrayList<>() ;
        BtweenKeys(root , start , end , result) ;
        return result ;
        
    }
     private void BtweenKeys(Node begin,Key start , Key end , ArrayList<Key>list){
         if(begin==null || begin.key.compareTo(start)<0 || begin.key.compareTo(end)>0)
             return ; 
        
        BtweenKeys(begin.left , start , end , list) ;
        list.add(begin.key) ;
        BtweenKeys(begin.right , start , end , list) ;
        return ;
         
     }
     

    public Key floor(Key key) {  // return  <= key 
        Node r = root;
        Key candiate = null;
        while (r != null) {    // r.key >  key 
            if (r.key.compareTo(key) > 0) {
                r = r.left;
            } else {
                if (r.key.compareTo(key) == 0) {
                    return r.key;
                }
                candiate = r.key;
                r = r.right;
            }
        }
        return candiate;

    }
    
    
  

    public Key ceil(Key key) {  // return  >= key 
        Node r = root;
        Key candiate = null;
        while (r != null) {    // r.key  < key 
            if (r.key.compareTo(key) < 0) {
                r = r.right;
            } else {
                if (r.key.compareTo(key) == 0) {
                    return r.key;
                }
                candiate = r.key;
                r = r.left;
            }
        }
        return candiate;
    }

    public int size(Key key) {
        Node node = getNode(key);
        return size(node) ;
    }
     private int size(Node node) {
       
        return node == null ? 0 : node.count;
    }
     
    
       public void delete(Key key) { 
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (getValueOf(key)==null) return;

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, key);
        if (root == null) root.color = BLACK;
        // assert check();
    }
         private Node delete(Node h, Key key) { 
        // assert get(h, key) != null;

        if (key.compareTo(h.key) < 0)  {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = getMin(h.right);
                h.key = x.key;
                h.value = x.value;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);
    }
         
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColor(h);
        if (isRed(h.right.left)) { 
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColor(h);
        }
        return h;
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColor(h);
        if (isRed(h.left.left)) { 
            h = rotateRight(h);
            flipColor(h);
        }
        return h;
    }
     private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColor(h);

        h.count = size(h.left) + size(h.right)+ 1;
        return h;
    }
      private Node deleteMin(Node h) { 
        if (h.left == null)
            return null;

        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) {
            return;
        }
        inorder(x.left, q);
        q.push(x.key);
        inorder(x.right, q);
    }

    private class Node {

        private Key key;          // abdullah 
        private Value value;  // 12
        private int count;
        private Node left, right;
        private boolean color;

        public Node(Key k, Value v) {
            this.key = k;
            this.value = v;
            count++;
            color = RED;
        }
    }
    
    
    
               
                
                

                

                }

