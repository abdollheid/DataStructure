package learning_datastrucure.sortion;

import java.util.Arrays;
import learning_datastrucure.Shuffle;


public class QuickSort {
  
    public static  void sort(Comparable a[]){
        Shuffle.start(a);
        sort(a,0,a.length-1) ;
    }
    private static void sort(Comparable a[] , int low , int high ){
        if(low>=high)
            return ;
        int j = partition(a,low,high) ; 
        sort(a,low,j-1) ;
        sort(a,j+1, high) ;
    }
    
    
    private static int partition(Comparable a[] , int low , int high){
        int i = low  ; 
        int j = high+1 ; 
        
        while(true){
            while(less(a[++i],a[low])){
                if(i==high){
                   break ;
               }
            }
            while(less(a[low],a[--j])){
                if(j==low){
                    break; 
                }
            }
            if(i>=j){
                break  ;
            }
           swap(a,i,j) ;
              }
        swap(a,low,j) ; 
          
        return j ;
    }
    
    
    private static boolean less(Comparable n1, Comparable n2){
        if(n1.compareTo(n2)==-1){
            return true ; 
        }else{
            return false ; 
        }
    }
    
    private static void swap(Comparable a[] , int index1 , int index2 ){
        Comparable temp = a[index1] ; 
        a[index1] = a[index2] ;
        a[index2] = temp  ;
    }
    
        public static  void sort(int a[]){
        Shuffle.start(a);
        sort(a,0,a.length-1) ;
    }
      
        
        
        
        
        
        
        
        private static void sort(int a[] , int low , int high ){
 // low    high
            if(low>=high){
                
            return ;      
            }
    
       
        int j = partition(a,low,high) ; 
      // sort 1 
        sort(a,low,j-1) ;
      // sort 2
        sort(a,j+1, high) ;
    }
    
        
        
        
        
        private static int partition(int a[] , int low , int high){
        int i = low  ; 
        int j = high+1 ; 
        
        while(true){
            while((a[++i]<a[low])){
                if(i==high){
                   break ;
               }
            }
            while((a[low]<a[--j])){
                if(j==low){
                    break; 
                }
            }
            
            if(i>=j){
                break  ;
            }
           swap(a,i,j) ;
            
        }
        swap(a,low,j) ; 
          
        return j ;
    }
    private static void swap(int a[] , int index1 , int index2 ){
        int temp = a[index1] ; 
        a[index1] = a[index2] ;
        a[index2] = temp  ;
    }
    
    
         public static  void sortEnhanced(int a[]){
        Shuffle.start(a);
        sortEnhanced(a,0,a.length-1) ;
    }
      
        
        
        
        
        
        
        
        private static void sortEnhanced(int a[] , int low , int high ){
 // low    high
            if(low+10>=high){
                InsertionSort.sort(a,low,high);
            return ;      
            }
    
       
        int j = partition(a,low,high) ; 
      // sort 1 
        sort(a,low,j-1) ;
      // sort 2
        sort(a,j+1, high) ;
    }
        
        
       
    
    private static void print(int ar[] ,int low , int high){
        int index[] = new int[ar.length] ;
        for(int i =0; i <ar.length ;++i){
            index[i]=i ;
        }
        //System.out.println("low: "+low +" high: "+high);
        System.out.println(Arrays.toString(index));
        System.out.println(Arrays.toString(ar));
        
    }
}
