package WeightedDirectedGraph;

import java.util.ArrayList;

public class DirectedWeightedGraph {
       private int numberOfVerticies  , numberOfEdges  ;
       private ArrayList<DirectedEdge> verticies []   ;
       
     
       public DirectedWeightedGraph(int size ){
         numberOfVerticies = size; 
         verticies =  new ArrayList[size] ; 
         
         for(int i =0 ; i < size ; ++i)
             verticies[i] = new ArrayList<DirectedEdge>() ;
         
      }
     
     public void addEdge(DirectedEdge edge ){
      
         
         int v1 = edge.from() ; 
         verticies[v1].add(edge) ;
         
         numberOfEdges++;
     }
     
     public int getVertexNumber(){
         return numberOfVerticies ; 
     }
     public int getEdgeNumber(){
         return numberOfEdges ;
     }
     
     public Iterable<DirectedEdge> adj(int vertex){
         return verticies[vertex] ;
     }
     
    
}
