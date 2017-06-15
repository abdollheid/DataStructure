package learning_datastrucure;

import java.util.Random;

public class Shuffle {
    
    
    private Shuffle(){
        
    }
    
    public static void start (Object elements []){
        Random rand =new Random();
        for(int i=0;i<elements.length;++i){
            int randomV = rand.nextInt(i+1);
            Object temp = elements[i]; 
            elements[i]=elements[randomV];
            elements[randomV]=temp;
               }
        
    }
       public static void start (int elements []){
        Random rand =new Random();
        for(int i=0;i<elements.length;++i){
            int randomV = rand.nextInt(i+1);
            int temp = elements[i]; 
            elements[i]=elements[randomV];
            elements[randomV]=temp;
               }
        
    }
}
