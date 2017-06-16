package learning_datastrucure;
 

public class Node{
        private Node next ; 
        private int value ; 
       
        public Node(int value){
            this.value  =value ; 
        }
        
        public void AddNext(Node nextNode){
           next = nextNode ;
        }
        
        public int getValue(){
            return value ;
        }
        
        public Node getNext(){
            return next ; 
        }
        
        
     }