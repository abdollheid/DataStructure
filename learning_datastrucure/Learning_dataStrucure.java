  package learning_datastrucure;

import java.math.BigInteger;
import java.text.DateFormat;

import learning_datastrucure.sortion.*;
import learning_datastrucure.PriorityQueue_Max;


public class Learning_dataStrucure {
    public static void main(String[] args) throws Exception {
       
        
        
// String name = "abdo" ; 
  //String name2 = "abdo" ;
  //print(name.hashCode() == name2.hashCode()) ;
//        RedBlackBST<Integer,Integer>test  = new RedBlackBST<>() ;
//        BinraySearchTree<Integer,Integer> bst = new BinraySearchTree<>() ;
//        
////        test.put(1, Integer.MIN_VALUE);
////        test.put(2, Integer.MIN_VALUE);
////        test.put(3, Integer.MIN_VALUE);
////        print(test.size(1));
////        print(test.size(2));
////        print(test.size(3));
////        bst.put(1, Integer.MIN_VALUE);
////        bst.put(2, Integer.MIN_VALUE);
////        bst.put(3, Integer.MIN_VALUE);
////        print(bst.size(1));
////        print(bst.size(2));
////        print(bst.size(3));
//        PriorityQueue <Integer> pq = new PriorityQueue<>(27) ;
//        int  valOfKeys[] = new int [27] ; 
//        int keys[] = new int [27] ;
//        
//        test.put(3, 1);
//        test.put(5, 1);
//        test.put(6, 1);
//        test.put(9, 2);
//        test.put(10, 1);
//        
//        test.put(12, 1);
//        test.put(15, 1);
//        
//        test.put(18, 1);
//        test.put(19, 1);
//        test.put(20, 1);
//        test.put(21, 1);
//        test.put(22, 1);
//        test.put(23, 1);
//        test.put(24, 1);
//        test.put(25, 1);
//        test.put(26, 1);
//        
//        
//        ArrayList<Integer>list=test.elementsBtweenKeys(8, 23) ;
//        for(int i =0  ; i < list.size() ; ++i)
//            print(list.get(i)) ;
//        
//        for(int i  = 0 ; i <27  ; ++i) {
//            Integer temp = test.size(i) ;
//            valOfKeys[i] = temp ==null ? 0 : temp  ;
//            keys[i] = i ; 
//            //pq.insert(temp ==null ? 0 : temp  ) ;
//        }
//        
//        for(int i = 0 ; i < 27 ; ++i){
//            for(int x = 0 ; x < 26 ; ++x){
//                if(valOfKeys[x]<valOfKeys[x+1]){
//                    swap(valOfKeys , x , x+1 ) ; 
//                    swap(keys ,x , x+1) ;
//                } 
//            }
//        }
//        for(int i =0 ; i < 27 ; ++i){
//            print(keys[i]+": "+valOfKeys[i]); 
//        }
//
//
////test.put(6066, Integer.MIN_VALUE);
//        //print(test.floor(17)); 
//        
//        
//           // print(test.size(20)) ;
//            test.delete(6066);
//            print(test.getMax());
//       
       
       
        
        
//Date d = new Date();
//System.out.println(DateFormat.getDateInstance().format(d));
  
        
//        int size =100_000_000;
//        int numbers1[]=new int [size];
//        int numbers2[]=new int [size];
//        int numbers3[]=new int [size];
//        
//        Random test =new Random();
//        
//        for(int i =0;i<numbers1.length;++i){
//          int temp =test.nextInt(100);
//          numbers1[i]=temp ;
//          numbers2[i]=temp ;
//          numbers3[i]=temp;
//        }

   //   System.out.println( Arrays.toString(numbers1));
      
      

//        long t0=System.currentTimeMillis(); 
//        threeWayPartitionSort(numbers1 , 0 , numbers1.length-1) ;
//        long t1 =System.currentTimeMillis();
//       Quick3way.sort(numbers2) ;
//        long t2 =System.currentTimeMillis();
//        Arrays.sort(numbers3);
//        long t3=System.currentTimeMillis();
        
      
//   
//       System.out.println("my key QuickSort: "+(t1-t0)+" ms");
//       System.out.println("keys QuickSort:  "+(t2-t1)+" ms");
//       System.out.println("java QuickSort: "+(t3-t2)+" ms");
//       System.out.println(Arrays.toString(numbers1));
//       System.out.println(Arrays.toString(numbers2));
//       System.out.println(Arrays.toString(numbers3));

//       Integer ar []  = {4,3,44,3,2,9} ;
//       Quick3way.sort(ar) ;
//       System.out.println(Arrays.toString(ar));
       
    }
    
    public static void swap (int ar[] , int i , int j ){
        int temp = ar[i] ; 
        ar[i] = ar[j] ;
        ar[j] = temp ; 
    }
    
    
    public static void print(Object message){
        System.out.println(message);
    }
    
    
    
    
}

    
    











   

    
    
    


