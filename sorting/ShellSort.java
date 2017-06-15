
package learning_datastrucure.sortion;


public class ShellSort {
    private ShellSort(){ 
    }
 
    public static void sort (Comparable elements[] ){
        int x = findX(elements.length);
        while (x>0){
            
            for(int i =x ;i<elements.length;++i){  // 4  2 3 2 1
                for(int  j=i ;j>=x &&elements[j].compareTo(elements[j-x])==-1;j-=x){
                    Comparable temp = elements[j];
                    elements[j] = elements[j-x];
                    elements[j-x]=temp;
                }
            }
            
            
            x=x/3;
            
            
            
        }
                
                
                
                
                
    }
    
    public static void sort (Comparable elements[] ,int low , int high){
        int len=(high-low)+1;
        int x = findX(len);
        while (x>0){
            
            for(int i =x+low ;i<=high;++i){  // 4  2 3 2 1
                for(int  j=i ;j>=x &&elements[j].compareTo(elements[j-x])==-1;j-=x){
                    Comparable temp = elements[j];
                    elements[j] = elements[j-x];
                    elements[j-x]=temp;
                }
            }
            
            
            x=x/3;
            
            
            
        }
                
                
                
                
                
    }
    private static  int findX(int size){
        int x =1 ;
        while (x<=size/3){
            x=((3*x)+1);
        }
        return x ;
    }
    
    
}
