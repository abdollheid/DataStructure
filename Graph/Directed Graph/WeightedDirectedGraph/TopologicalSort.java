
package WeightedDirectedGraph;

import java.util.*;

public class TopologicalSort {
    private int order []; 
    private int index ; 
    private boolean marked[] ; 
    private DirectedWeightedGraph graph ; 
    
    public TopologicalSort(DirectedWeightedGraph graph){
        this.graph = graph ;
        index = graph.getVertexNumber() - 1 ; 
        order = new int [graph.getVertexNumber()] ; 
        marked = new boolean [graph.getVertexNumber()] ;
        
        for(int i = 0 ; i < graph.getVertexNumber() ; ++i){
            if(!marked[i]){
                dfs(i) ; 
            }
        }
    }
    
    private void dfs(int workingNumber){
        
        marked[workingNumber] = true ; 
        for(DirectedEdge e : graph.adj(workingNumber)){
            if(!marked[e.to()])
                dfs(e.to()) ; 
        }
        order[index--] = workingNumber ; 
    }
    
   public int [] topoOrder(){
       return order ; 
   }
   
   public static void main(String args[]){
       Scanner in = new Scanner(System.in) ;
       int v = in.nextInt() ; 
       int e = in.nextInt() ; 
       DirectedWeightedGraph g = new DirectedWeightedGraph(v) ;
       for(int i =0 ; i < e ; ++i){
           int from = in.nextInt() ; 
           int to = in.nextInt() ; 
           double weight = in.nextDouble() ;
       g.addEdge(new DirectedEdge(from , to  , weight ));
       }
       
       TopologicalSort test = new TopologicalSort(g) ;
       int ans[] = test.topoOrder() ;
       for(Integer i : ans){
           System.out.print(i);
       }
       System.out.println(); 
   }
}
