package DataStructure.WeightedDirectedGraph;

import java.util.ArrayList;
import java.util.Random;

public class DirectedWeightedGraph {
       private int numberOfVerticies  , numberOfEdges  ;
       private ArrayList<DirectedEdge> verticies []   ;
       
     
       public DirectedWeightedGraph( int size ){
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
     
     
     
     public boolean hasNegativeCycle(int source){
         boolean visited[] = new boolean[getVertexNumber()] ;
         DirectedEdge from [] = new DirectedEdge [getVertexNumber()] ; 
         boolean onTheLoop[] = new boolean[getVertexNumber()] ; 
         
         return dfsNegative(source, visited , from  , onTheLoop );
         
         
     }
  
     public boolean dfsNegative(int v , boolean visited[] , DirectedEdge from[] ,boolean  onTheLoop[]){
//         System.out.print(v + ",") ; 
         visited[v] = true ; 
         onTheLoop[v] = true ; 
         
         boolean end = false ; 
         
         for(DirectedEdge e  : verticies[v]){
             
             if(visited[e.to()]){
             if(onTheLoop[e.to()]){
                 double check =  getCycle(from , e) ; 
                 if(check < 0 )  return true  ;
             
             } } 
             else{
                 from[e.to()] = e ; 
                 end = dfsNegative(e.to(), visited, from, onTheLoop ) ; 
             }
             if(end) return true ; 
         }
         
         onTheLoop[v] = false ; 
         
         
         return end ; 
     }
     
     
     private double getCycle(DirectedEdge from[], DirectedEdge thisEdge){
         int end = thisEdge.from() ; 
         int start = thisEdge.to() ; 
         double weight = thisEdge.getWeight() ;
       
         do{
//             System.out.print(end + ", ")  ;
             weight += from[end].getWeight() ; 
             end = from[end].from() ;
         }while(end != start) ;
//             System.out.println(end + " weight= " + weight)  ;
             
             return weight ; 
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
     
    public static void main(String args[]){
         
//         g.addEdge(new DirectedEdge(0 , 1 , 1));
//         g.addEdge(new DirectedEdge(1 , 2 , 10));
//         g.addEdge(new DirectedEdge(2 , 0 , 100));
         
//         DirectedWeightedGraph g  = new DirectedWeightedGraph(7) ;
//         
//         g.addEdge(new DirectedEdge(0 , 1 , 1));
//         g.addEdge(new DirectedEdge(1 , 2 , 10));
//         g.addEdge(new DirectedEdge(1 , 3 , 100));
//         g.addEdge(new DirectedEdge(2 , 3 , 1_000));
//         g.addEdge(new DirectedEdge(3 , 4 , 10_000));
//         g.addEdge(new DirectedEdge(3 , 6 , 100_000));
//         g.addEdge(new DirectedEdge(4 , 2 , 1_000_000));
//         g.addEdge(new DirectedEdge(4 , 5 , 1_000_000));
//         g.addEdge(new DirectedEdge(5 , 3 , 10_000_000));
//         g.addEdge(new DirectedEdge(6 , 1 , -100_000_000));
//         g.addEdge(new DirectedEdge(4 , 2 , 1_000_000_000));
         
         DirectedWeightedGraph g  = getG(2500) ; 
         
         
         long t0 = System.currentTimeMillis() ; 
         System.out.println(g.hasNegativeCycle(0)) ; 
         long t1 = System.currentTimeMillis() ;
         
         System.out.println((t1-t0) +" ms") ; 
         
         
     }
     
      public static DirectedWeightedGraph getG(int v ){
       Random r = new Random(1) ; 
       
       System.out.println(v);
      DirectedWeightedGraph g  = new DirectedWeightedGraph(v) ;
       
       
       
       for(int i = 0 ; i < v ; ++i){
           for(int x = i + 1 ; x < v ;++x){
               
               g.addEdge(new DirectedEdge(i , x , r.nextInt(100)));
           }
       }
       
        return g ; 
        
    }
     
     
     
}

