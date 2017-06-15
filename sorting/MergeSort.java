/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_datastrucure.sortion;

import java.util.Arrays;

/**
 *
 * @author abdullah
 */
public class MergeSort {
//        private static int index[]={0,1,2,3,4,5,6,7};  // for test purposes

    private MergeSort(){
        // shouldnt be made as an object
    }
    
    private static void merge (Comparable elements[] ,Comparable aux[] , int low , int mid ,int high){
      //  aux = (Comparable[])elements.clone(); 
        for(int i =low ;    i <= high   ;  ++i){
            aux[i]=elements[i];
        }
        
        int i =low ; 
        int j = mid+1 ;
        
        for (int ic =low ; ic <=high ; ++ic){
            if (i>mid){
                elements[ic] = aux[j];
                ++j;
            }
            else {
                if(j>high){
                    elements[ic]=aux[i];
                    ++i;
                }
                else {
                    if(aux[i].compareTo(aux[j])==1){
                        elements[ic]=aux[j++];
                    }
                    else {
                        elements[ic] = aux[i++];
                    }
                }
            }

            
            
        }
        
        
       
        
       
        
        
        
        
        
    }
    
    private static void sort(Comparable elements[] , Comparable aux[] , int low , int high ){
    if(low>=high){
        return;
    }
        int mid = (low+high)/2 ;
      
//         System.out.println("Before sort1");
//      System.out.println("Low: "+low+"\tMid: "+mid+"\tHigh: "+high);
  
   
      
      sort(elements , aux , low , mid );
        
        
//        System.out.println("Before sort 2");
//        System.out.println("Low: "+low+"\tMid: "+mid+"\tHigh: "+high);
  
        
 
        sort (elements , aux , mid+1 , high);
        
        
        
//        System.out.println("Before the merge");
//        System.out.println(Arrays.toString(index));
//        System.out.println(Arrays.toString(elements));
//        System.out.println("Low: "+low+"\tMid: "+mid+"\tHigh: "+high);
//        System.out.println("AUX: "+print(aux,low,high));
//        System.out.println("Elements: "+print(elements,low,high));
     
           
           
           merge(elements , aux , low  , mid , high);
        
           
           
           
//           System.out.println("after the Merge");
//           System.out.println("AUX: "+print(aux,low,high));
//           System.out.println("Elements: "+print(elements,low,high));
//           System.out.println("\n------------------------------------------------------------\n");
     }
    
    public static void sort (Comparable elements[]){
        Comparable aux [] = new Comparable[elements.length];
        sort(elements , aux , 0 ,elements.length-1);
    }
    
    
     public static void sort (int elements[]){
        int aux [] = new int[elements.length];
        sort(elements , aux , 0 ,elements.length-1);
    }
     
         private static void sort(int elements[] , int aux[] , int low , int high ){
    if(low>=high){
        return;
    }
        int mid = (low+high)/2 ;
      
//         System.out.println("Before sort1");
//      System.out.println("Low: "+low+"\tMid: "+mid+"\tHigh: "+high);
  
   
      
      sort(elements , aux , low , mid );
        
        
//        System.out.println("Before sort 2");
//        System.out.println("Low: "+low+"\tMid: "+mid+"\tHigh: "+high);
  
        
 
        sort (elements , aux , mid+1 , high);
        
        
        
//        System.out.println("Before the merge");
//        System.out.println(Arrays.toString(index));
//        System.out.println(Arrays.toString(elements));
//        System.out.println("Low: "+low+"\tMid: "+mid+"\tHigh: "+high);
//        System.out.println("AUX: "+print(aux,low,high));
//        System.out.println("Elements: "+print(elements,low,high));
     
           
           
           merge(elements , aux , low  , mid , high);
        
           
           
           
//           System.out.println("after the Merge");
//           System.out.println("AUX: "+print(aux,low,high));
//           System.out.println("Elements: "+print(elements,low,high));
//           System.out.println("\n------------------------------------------------------------\n");
     }
         
             private static void merge (int elements[] ,int aux[] , int low , int mid ,int high){
      //  aux = (Comparable[])elements.clone(); 
        for(int i =low ;    i <= high   ;  ++i){
            aux[i]=elements[i];
        }
        
        int i =low ; 
        int j = mid+1 ;
        
        for (int ic =low ; ic <=high ; ++ic){
            if (i>mid){
                elements[ic] = aux[j];
                ++j;
            }
            else {
                if(j>high){
                    elements[ic]=aux[i];
                    ++i;
                }
                else {
                    if(aux[i]>aux[j]){
                        elements[ic]=aux[j++];
                    }
                    else {
                        elements[ic] = aux[i++];
                    }
                }
            }

            
            
        }
        
        
       
        
       
        
        
        
        
        
    }


//    private static String print(Comparable elements [] , int start , int end){
//
//        String answer="";
//        
//        for(int i =0 ; i<(end-start)+1;++i){
//           answer+=elements[start+i]+", ";
//        }
//    
//        return answer;
//    }
//
}
