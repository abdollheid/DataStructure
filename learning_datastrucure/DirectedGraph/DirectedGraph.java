/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_datastrucure.DirectedGraph;

import learning_datastrucure.Node;
import learning_datastrucure.NodeIterator;

/**
 *
 * @author abdo
 */
public class DirectedGraph {
    
     private int numberOfVerticies, numberOfEdges;
     private Node verticies[] , reversedVersion[];
     
     
     public  DirectedGraph(int size ){
         numberOfVerticies = size; 
         verticies =  new Node[size] ; 
         reversedVersion = new Node[size] ; 
         
      }
     
     public void addEdge(int v1 , int v2){
         Node temp  = verticies[v1]   ;
         verticies[v1] = new Node(v2) ;
         verticies[v1].AddNext(temp);
         
         temp = reversedVersion[v2] ; 
         reversedVersion[v2] = new Node(v1) ; 
         reversedVersion[v2].AddNext(temp);
         
         
         ++numberOfEdges ;
     }
     
     
     
     public int getVertexNumber(){
         return this.numberOfVerticies ; 
     }
     
     public Iterable<Integer> adj(int vertex){
         return new NodeIterator(verticies[vertex]) ; 
     }  
     
     public Iterable<Integer>adjReversedVersion(int vertex) {
         return new NodeIterator(reversedVersion[vertex]) ; 
     }
     
     public static void main(String args[]){
         DirectedGraph g = new DirectedGraph(4) ; 
         g.addEdge(0, 1);
         g.addEdge(1, 2);
         g.addEdge(2, 3);
         g.addEdge(3, 0);
         
         
         
         
//         
//         
////         
//          TopologicalSort t = new TopologicalSort(g) ;
//         for(int i : t.getReverseOrder() ){
//             System.out.print(i+",");
//         }
//         System.out.println();
         
         
         
         Kosaraju_SharirSCC t = new Kosaraju_SharirSCC(g) ;
         
         for(int i  = 0 ; i < t.ID ;++i){
             for(int x =0; x < t.id.length ; ++x){
                 if(t.id[x]==i)
                 System.out.print(x+",");
             }
             System.out.println() ;
         }
         
         

         
         
         
     }
}
