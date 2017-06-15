package Excersice;


import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item>{
    
    private Item queue[] ;
    private int size,first,last ; 
    private Random rand; 
    
   
    public RandomizedQueue(){ // construct an empty randomized queue
       queue =(Item[])(new Object[2])  ;
       rand = new Random() ; 
   } 
    public boolean isEmpty(){
       return size==0 ; 
   }                
    public int size() {
       return  size ; 
   }                     
   public void enqueue(Item item) {
       if(item == null) 
           throw new java.lang.NullPointerException() ; 
       
    if(last==queue.length){
        resize(queue.length *2);
       }
       queue[last]=item ;
       last++; 
       size++;
   }          
   public Item dequeue(){  // remove and return a random item
        if(isEmpty()){
           throw new java.util.NoSuchElementException() ; 
        }
       int choosenOne = rand.nextInt(size) ;
       Item value = queue[first+choosenOne] ; 
       queue[first+choosenOne] = queue[first] ; 
       --size ; 
       first++; 
       if(size==queue.length/4){
           resize(queue.length/2) ;
       }
       return value ; 
       
   }        
   public Item sample(){ // return (but do not remove) a random item
       if(isEmpty()){
           throw new java.util.NoSuchElementException() ; 
        }
    return queue[first+rand.nextInt(size)] ; 
       
   }      
  // public Iterator<Item> iterator()  {}       // return an independent iterator over items in random order
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
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            
            return dequeue();
        }
     
     
     }
   
   private void resize(int size){
        Item clone[] = (Item[])(new Object[size]);
        for(int i =first , x=0 ; i<last ; ++i , ++x){
            clone[x] = queue[i] ;
        }
        first=0 ; 
        last=size/2 ;
        queue= null ; 
        queue = clone ; 
    }
  
   public static void main(String[] args){
        RandomizedQueue<Integer> q = new RandomizedQueue<>() ; 
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3); 
        q.enqueue(4); 
        
        System.out.println(q.dequeue()) ; 
        System.out.println(q.dequeue()) ; 
        System.out.println(q.dequeue()) ; 
        System.out.println(q.dequeue()) ; 
     //   System.out.println(q.dequeue()) ; 
        
   
   }   
}
