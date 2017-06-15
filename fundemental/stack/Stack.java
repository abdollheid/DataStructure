
package learning_datastrucure;

import java.util.Iterator;

public class Stack<type>implements Iterable<type> {
    private Node<type> first;
    private int n ;
    
     private static class Node<type> {
         private type value;
         private Node next;
     }
     
     public Stack(){
         
     }
     public int getSize(){
         return n;
     }
     public boolean isEmpty(){
         return n==0;
     }
     public void push(type o){
         Node <type> old =first;
         first=new Node <type>();
         first.value=o;
         first.next=old;
         ++n;
        }
     
     public type pop(){
         if(isEmpty()){
             System.out.println("the stack is empty");
         }
        
         type value = first.value;
         first=first.next;
         --n;
         return value;
       }
    
     @Override  // public Iterator<T> iterator();
    public Iterator<type> iterator (){ 
        return new IteratorCopy();
    }
    
    private class IteratorCopy implements Iterator<type>{
        private IteratorCopy (){
        }
        
       @Override 
       public boolean hasNext(){
           return !isEmpty();
       }    
       
       
       @Override
       public type next(){
       return pop();
     } 
     
     
}

}
