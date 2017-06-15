
package learning_datastrucure;
import java.util.*;

public class Queue<Type> implements Iterable<Type>{ 
    private Node<Type> first ,last ;
    private int size ;
    
    
   
    
    private static class Node <Type>{
    private Type value ;
    private  Node next;   // default value = null
}
   
    public void Queue(){
        
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int getSize (){
        return size;
    }
    
    public void push(Type element){
       if(isEmpty()){
           last=new Node();
           last.value=element;
           first=last;
        
       }
       else {
           Node <Type> oldLast =last ;
           last =new Node();
           last.value=element;
           oldLast.next=last;
          
        }
        ++size;
    }
    public Type pop(){
           if(isEmpty()){
             System.out.println("the queue is empty");
         }
        
            Type value = first.value;
            if(first!=last){
            first = first.next;
            }
            --size;
            return value;
                    
        
    }
    
    @Override  // public Iterator<T> iterator();
    public Iterator<Type>iterator (){ 
        return new IteratorCopy();
    }
    
    private class IteratorCopy implements Iterator<Type>{
        private IteratorCopy (){
        }
        
        @Override 
       public boolean hasNext(){
           return !isEmpty();
       }  
       
       @Override
       public Type next(){
       return pop();
        } }



}
