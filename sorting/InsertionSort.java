
package learning_datastrucure.sortion;

import learning_datastrucure.Shuffle;

public class InsertionSort  {
    private InsertionSort(){
        //this class should be used without objects 
    }
    
    public static void sort(Comparable elements []){
        for(int i=1 ;i<elements.length;++i){
           for(int j =i  ; j>=1 && (elements[j].compareTo(elements[j-1])==-1) ;--j){
               Comparable temp =elements[j];
               elements[j]=elements[j-1];
               elements[j-1] = temp ;
                  }
        }  }
       public static void sort(int elements []){
           Shuffle.start(elements);
        for(int i=1 ;i<elements.length;++i){
           for(int j =i  ; j>=1 && (elements[j]<(elements[j-1])) ;--j){
               int temp =elements[j];
               elements[j]=elements[j-1];
               elements[j-1] = temp ;
                  }
        }  }
       
          public static void sort(int elements [] , int low , int high){
        for(int i=low+1 ;i<=high;++i){
           for(int j =i  ; j>=low+1 && (elements[j]<(elements[j-1])) ;--j){
               int temp =elements[j];
               elements[j]=elements[j-1];
               elements[j-1] = temp ;
                  }
        }  }
    
    
    
    
}
