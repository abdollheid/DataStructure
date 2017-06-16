
package learning_datastrucure;

import java.util.Iterator;


public class NodeIterator implements Iterable {
    private Node first ; 
    
    public NodeIterator(Node first){
        this.first = first ; 
    }
    
    
    public int nodeValue(){
        Node temp = first ; 
        first = first.getNext() ; 
        return temp.getValue() ; 
    }
    public boolean hasNextNode(){
        return first != null ; 
    }
    
    public Iterator iterator (){ 
        return new IteratorCopy();
    }
    
    private class IteratorCopy implements Iterator{
        private IteratorCopy (){
        }
        
       @Override 
       public boolean hasNext(){
           return hasNextNode();
       }    
       
       
       @Override
       public Integer next(){
       return nodeValue();
     } 
     
     
}
}
