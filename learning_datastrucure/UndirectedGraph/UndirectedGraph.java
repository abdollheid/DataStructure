package learning_datastrucure.UndirectedGraph;

import java.util.Iterator;
import learning_datastrucure.Node;
import learning_datastrucure.NodeIterator;


public class UndirectedGraph  {
     private int numberOfVerticies  , numberOfEdges  ;
     private Node verticies []   ;
     
     public  UndirectedGraph(int size ){
         numberOfVerticies = size; 
         verticies =  new Node[size] ; 
         
      }
     
     public void addEdge(int v1 , int v2){
         Node temp  = verticies[v1]   ;
         verticies[v1] = new Node(v2) ;
         verticies[v1].AddNext(temp);
         
         
         temp = verticies[v2] ;
         verticies[v2] = new Node(v1) ;
         verticies[v2].AddNext(temp); 
         
         ++numberOfEdges ;
     }
     
     public int getVertexNumber(){
         return this.numberOfVerticies ; 
     }
     
     public Iterable<Integer> adj(int vertex){
         return new NodeIterator(verticies[vertex]) ; 
     }
     
  
   
   
   public static void main(String args[]){
       UndirectedGraph gr = new UndirectedGraph(13);
       gr.addEdge(0, 1);
       gr.addEdge(0, 2);
       gr.addEdge(0, 6);
       gr.addEdge(0, 5);
       gr.addEdge(6, 4);
       gr.addEdge(4, 5);
       gr.addEdge(4, 3);
       gr.addEdge(3, 5);
      
       gr.addEdge(7, 8);
       
       gr.addEdge(9, 10);
       gr.addEdge(9, 12);
       gr.addEdge(11, 12);
       gr.addEdge(9, 11);
       
       ConnectedComponent c = new ConnectedComponent(gr) ; 
       for(int i = 0 ; i < c.ID ; ++i){
           for(int x = 0 ; x < gr.numberOfVerticies ;++x){
               if(c.id[x] == i)
               System.out.print(x+",");
           }
           System.out.println();
       }
 
       
       

       }


}
