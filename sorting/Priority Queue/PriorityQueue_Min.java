
package learning_datastrucure;

import java.util.*;

/**
 *
 * @author abdullah
 */
public class PriorityQueue_Min <Key extends Comparable<Key>>{
    private Key ar[] ; 
    private int n ;
    
    
    
    public PriorityQueue_Min(int size){ // 1 to size 
        ar = (Key[]) (new Comparable[size+1]) ;
        n++ ;
        
    }
    
   
    
    public void insert(Key element){
        ar[n] =element ; 
        swim(n) ;
        ++n ;
    }
    
    public  Key delMin() throws Exception{
        if(isEmpty())
            throw new Exception("the array is empty") ;
        Key temp = ar[1] ;
        ar[1] = ar[--n] ; 
        ar[n] = null ;
        sink(1) ; 
        return temp ; 
    }
    
    private void swim(int k){
        while(k>1 && less(k , k/2)){
            exch(k,k/2) ;
            k /= 2 ;
        }
    }
    
    private void sink(int k ){
        while(k*2<n){
            int k2 ;
         if((k*2)+1<n)
          k2= min(k*2, (k*2)+1) ; 
         else{
             k2= k*2 ;
         }
         if(less(k2,k)){
         exch(k2 , k) ;
         k = k2 ; 
         }
         else{
             break ; 
         }
         
        }
    }
    
    private int min(int k1 ,int k2){
        if(less(k1,k2)){
            return k1;
        }else{
            return k2; 
        }
    }
    
    
    
    
     private boolean less(int k1 , int k2){
        return ar[k1].compareTo(ar[k2])==-1 ; 
    }
     
    private void exch(int k1 , int k2) {
        Key temp = ar[k1] ; 
        ar[k1] = ar[k2] ; 
        ar[k2] = temp ;
    }
    
    public boolean isEmpty(){
        return n==1 ;
    }
    
    public static void main (String args[])throws Exception{
        int size = 10_000_000 ; 
          PriorityQueue_Min<Integer> pq = new PriorityQueue_Min<>(size);
//          for(int i = size ; i >0 ; --i)
//              pq.insert(i);
//          for(int i = 0 ; i < size ; ++i)
//              System.out.println(pq.delMin()) ;
          
        int ar [] = new int[size] ; 
        Random rand = new Random();
        
        for(int i =0 ; i < size ; ++i){
            int randTemp = rand.nextInt(Integer.MAX_VALUE) ; 
            ar[i] = randTemp ;
            pq.insert(randTemp);
            
        }
        
        Arrays.sort(ar); 
        for(int i = 0 ; i < size ; ++i){
            int temp = pq.delMin() ; 
            if(ar[i]!=temp){
                System.out.println(temp+" should be: "+ar[i]); 
                throw new Exception("there is difference in Values") ;
                
            }
        }
        System.out.println("everyThings is working fine !");
//        
        
        
        
    }
    
}
