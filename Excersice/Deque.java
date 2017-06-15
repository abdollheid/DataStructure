package Excersice;


import java.util.Iterator;


public  class Deque <Item> implements Iterable<Item> {
    private Node start , end ;  // null 
    private int size ; 
    
    
    private class Node{
     private Item val  ; 
     private Node previous , next ; 
     
     private Node(Item val){
         this.val = val ; 
     }
    }
    
    public Deque(){
    } 
   
    public void addFirst(Item item){
        if(item==null) 
            throw new java.lang.NullPointerException() ; 
        if(isEmpty()){
            start = end = new Node(item) ; 
            ++size ;
            return ; 
        }
        Node tempStart = start ; 
        start = new Node(item)  ;
        start.next = tempStart ; 
        tempStart.previous = start ; 
        ++size ; 
    }
    
     public void addLast(Item item){
         if(item==null)  throw new java.lang.NullPointerException() ; 
     
         if(isEmpty()){
            start = end = new Node(item) ; 
            ++size ;
            return ; 
        }
        Node tempEnd = end ; 
        end = new Node(item);
        end.previous = tempEnd ; 
        tempEnd.next = end ; 
        ++size ; 
     }
     
      public Item removeFirst(){
          if(isEmpty()) throw new java.util.NoSuchElementException(); 
          Node NodeToBeRemoved =  start  ; 
          
          if(size>1) {
          start = start.next ; 
          start.previous = null ; 
          }
          size-- ;
          
          return NodeToBeRemoved.val ; 
          
      }
      
      
      public Item removeLast()  {
          if(isEmpty()) throw new java.util.NoSuchElementException(); 
          
          Node NodeToBeRemoved =  end  ; 
          if(size>1){
          end = end.previous ; 
          end.next = null ;  
          } 
          size-- ; 
          
          return NodeToBeRemoved.val ; 
      }
    
    
    
    
    
    
    public boolean isEmpty(){
    return size == 0 ; 
    }
    public int size() {
        return size ; 
    }
    
  
    
    
    public Iterator<Item> iterator(){
        return new IteratorCopy(); 
    }
    
     private class IteratorCopy implements Iterator<Item>{
        private IteratorCopy (){
        }
        
      
        public boolean hasNext()  {
            return isEmpty(); 
        }
        public void remove() {
            throw new UnsupportedOperationException(); 
        }

        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            
            return removeFirst();
        }
     
     
     }
     
     
     
     public static void main(String arg[] ) { 
      Deque<Integer> d = new Deque<>() ; 
      
      
      
     
     }
     
     
    
}
