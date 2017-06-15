
package learning_datastrucure.sortion;

public class SelectionSort {
   private SelectionSort(){
       
   }
   public static void sort(Comparable elements []){
       for(int i =0 ; i<elements.length-1;++i){
           Comparable min=elements[i];
           int index =i;
           for(int x =i;x<elements.length;++x){
               if(elements[x].compareTo(min)==-1){
                   min = elements[x];
                   index = x ;
               }
               
           }
           Comparable temp =elements [i];
           elements[i]=min;
           elements[index]=temp;
           
           
       }
       
   }
    
}
