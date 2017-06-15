
package learning_datastrucure;

import java.util.Arrays;

public class QueueWithArray<Type> { // generic type defined in the run time
    public Type queue[] ;
    private int size , first , last ; 
    
    public QueueWithArray(){
        queue =(Type[])(new Object[2])  ;
    }
    
    public void push(Type element){ ///
                                                              ///       first    2nd    3rd    last   
       if(last==queue.length){
           resize(queue.length *2);
       }
       queue[last]=element ;
       last++; 
       size++;
    }
    
    public Type pop(){
        if(isEmpty()){
           return null ;
        }
       Type value = queue[first] ; 
       --size ; 
       first++; 
       if(size==queue.length/4){
           resize(queue.length/2) ;
       }
       return value ; 
       
    }
    
    private void resize(int size){
        Type clone[] = (Type[])(new Object[size]);
        for(int i =first , x=0 ; i<last ; ++i , ++x){
            clone[x] = queue[i] ;
        }
        first=0 ; 
        last=size/2 ;
        queue= null ; 
        queue = clone ; 
    }
    
    public boolean isEmpty(){
            return size==0 ;
    }
    
    public static void main(String args[]){
        QueueWithArray<Integer> q = new QueueWithArray<>()  ;
        q.push(1);
        System.out.println(Arrays.toString(q.queue))  ;
        q.push(2);
        System.out.println(Arrays.toString(q.queue))  ;
        q.push(3);
        System.out.println(Arrays.toString(q.queue))  ;
        q.push(4);
        System.out.println(Arrays.toString(q.queue))  ;
        q.push(5);
        System.out.println(Arrays.toString(q.queue))  ;
        System.out.println(q.pop());
        System.out.println(Arrays.toString(q.queue))  ;
        System.out.println(q.pop());
        System.out.println(Arrays.toString(q.queue))  ;
        System.out.println(q.pop());
        System.out.println(Arrays.toString(q.queue))  ;
        System.out.println(q.pop());
        System.out.println(Arrays.toString(q.queue))  ;
        System.out.println(q.pop());
        System.out.println(Arrays.toString(q.queue))  ;
       
    
    
    
        
    
    }
            
            
}
