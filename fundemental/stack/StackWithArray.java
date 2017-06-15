
package learning_datastrucure;
import java.util.*;
public class StackWithArray <Type> implements Iterable <Type>{
   private  Type stack[];
   private int index;
    
    public StackWithArray(){
        stack=(Type[])new Object[2];
       
    }
    
    public void push(Type element){
        if(stack.length==index){
            resize(index*2);
        }
        stack[index++]=element;
        
    }

    public Type pop(){
        if(index==0){
           System.out.println("the array is empty");
        }
        if(index==stack.length/4){
            resize(stack.length/2);
        }
        Type v=stack[--index];
        stack[index]=null;
        return v;
    }
    public boolean isEmpty(){
    return index==0;
} 
    private void resize(int size ){
        Type c[]=(Type [])new Object[size];
        for (int i=0;i<index;++i){
            c[i]=stack[i];
        }
        stack=null;
        stack=c;
        
    }
    
    
        
    @Override  // public Iterator<T> iterator();
    public Iterator<Type> iterator (){ 
        return new IteratorCopy();
    }
    
    private class IteratorCopy implements Iterator<Type>{
        private IteratorCopy (){
        }
        
       @Override 
       public boolean hasNext(){
           return !isEmpty();
       }    
       
       @Override
       public Type next(){
       return pop();
     } 
     
     
}

    
    
}
