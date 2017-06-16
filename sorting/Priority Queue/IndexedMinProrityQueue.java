
public class IndexedMinProrityQueue <Key extends Comparable<Key>> {
    private int positionsOfIndicies[] , IndiciesOfPositions[] , n; 
    private Key ar [] ;
    
    public IndexedMinProrityQueue(int size ){
        ar = (Key[]) (new Comparable [size + 1] ); 
        positionsOfIndicies = new int [size] ; 
        IndiciesOfPositions = new int[size+1] ; 
        n++ ; 
    }
    
    
    public void insert(Key element , int index ){
        ar[n] =element ; 
        positionsOfIndicies[index]= n ;
        IndiciesOfPositions[n] = index ; 
        swim(n) ;
        ++n ;
    }
    
    public  Key delMin() throws Exception{
        if(isEmpty())
            throw new Exception("the array is empty") ;
        
        Key temp = ar[1] ;
        //ar[1] = ar[--n] ; 
        exch(1,--n) ; 
        ar[n] = null ;
        positionsOfIndicies[IndiciesOfPositions[n]] = -1 ; 
        IndiciesOfPositions[n] = -1 ;
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
    
    
    public void decreaseKey(int index ,Key val){
        ar[positionsOfIndicies[index]] = val ; 
        swim(positionsOfIndicies[index]) ; 
    }
    
    
    
     private boolean less(int k1 , int k2){
        return ar[k1].compareTo(ar[k2])==-1 ; 
    }
     
     
     
    private void exch(int k1 , int k2) { // k1 = 2 , k2 = 1 ; 
        Key temp = ar[k1]; 
        ar[k1] = ar[k2]; 
        ar[k2] = temp;
        
        
        int index =IndiciesOfPositions[k1] ; 
        IndiciesOfPositions[k1] = IndiciesOfPositions[k2] ; 
        IndiciesOfPositions[k2] = index ; 
        
        positionsOfIndicies[IndiciesOfPositions[k1]] = k1;
        positionsOfIndicies[IndiciesOfPositions[k2]] = k2;
        
        
        
    }
    
    public int vertexInPosition(int pos){
        return IndiciesOfPositions[pos] ;
    }
    
    public int positionOfVertex(int vertex){
        return positionsOfIndicies[vertex] ; 
    }
    
    public Key valueOfIndex(int index){
        return ar[index] ; 
    }
    
    public boolean isEmpty(){
        return n==1 ;
    }
    
    static class Container implements Comparable<Container>{
        int value , vertex ;
        
        public Container(int  v , int p ){
            value = v ;
            vertex = p ; 
        }

        @Override
        public int compareTo(Container o) {
           if(value>o.value)
               return 1 ; 
           else
               if(value<o.value)
                   return -1 ; 
               else 
                   return 0 ;
            
        }
        
    }
    
    
    
}
