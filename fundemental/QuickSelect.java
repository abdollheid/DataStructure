package learning_datastrucure;


public class QuickSelect {

    public static int select(int a[] , int k  ){
        int low = 0 , high = a.length -1 ; 
    
        while(low<high){   
           
        int j = partition(a , low ,high) ;
       
        if(j>k) 
            high = j-1 ;
       
        else if(j<k) 
            low  = j+1 ;
        
        else
            return a[j] ; 
            
        
        }
        
        return a[k]; 
        
        
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
}
