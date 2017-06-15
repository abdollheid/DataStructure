
package learning_datastrucure;

/**
 *
 * @author abdullah
 */
public class PriorityQueue_Max <Key extends Comparable<Key>>{
    private Key ar[] ; 
    private int n ;
    
    
    
    public PriorityQueue_Max(int size){ // 1 to size 
        ar = (Key[]) (new Comparable[size+1]) ;
        n++ ;
        
    }
    
   
    
    public void insert(Key element){
        ar[n] =element ; 
        swim(n) ;
        ++n ;
    }
    
    public  Key delMax() throws Exception{
        if(isEmpty())
            throw new Exception("the array is empty") ;
        Key temp = ar[1] ;
        ar[1] = ar[--n] ; 
        ar[n] = null ;
        sink(1) ; 
        return temp ; 
    }
    
    private void swim(int k){
        while(k>1 && less(k/2 , k)){
            exch(k,k/2) ;
            k /= 2 ;
        }
    }
    
    private void sink(int k ){
        while(k*2<n){
            int k2 ;
         if((k*2)+1<n)
          k2= max(k*2, (k*2)+1) ; 
         else{
             k2= k*2 ;
         }
         if(less(k,k2)){
         exch(k2 , k) ;
         k = k2 ; 
         }
         else{
             break ; 
         }
         
        }
    }
    
    private int max(int k1 ,int k2){
        if(less(k1,k2)){
            return k2 ;
        }else{
            return k1 ; 
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
    
    public static void main (String args[]){
        PriorityQueue_Max<Integer> pq = new PriorityQueue_Max<>(8);
        
        
    }
    
}
