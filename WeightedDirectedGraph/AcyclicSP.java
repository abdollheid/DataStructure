
package WeightedDirectedGraph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import learning_datastrucure.Stack;

public class AcyclicSP {
    private double distTo[] ; 
    private DirectedEdge cameFrom [] ; 
    private int source ; 
    
    public AcyclicSP(DirectedWeightedGraph graph , int source){
        this.source = source; 
        distTo = new double [graph.getVertexNumber()] ; 
        cameFrom = new DirectedEdge[graph.getVertexNumber()] ; 
        
        fill(distTo , Double.POSITIVE_INFINITY ) ; 
        distTo[source] = 0 ; 
        
        TopologicalSort order = new TopologicalSort(graph) ; 
        
        for(Integer i : order.topoOrder()){
            for(DirectedEdge edg : graph.adj(i)){
                if(distTo[edg.to()] > distTo[edg.from()] + edg.getWeight()){
                    distTo[edg.to()] = distTo[edg.from()] + edg.getWeight() ; 
                    cameFrom[edg.to()] = edg ; 
                }
            }
        }
        
        
        
        
    }
    
    public boolean hasPathTo(int v){
        return distTo[v] != Double.POSITIVE_INFINITY ; 
    }
    
    public Iterable<DirectedEdge> pathTo(int v){
        Stack<DirectedEdge> path = new Stack<>() ;
        while(cameFrom[v].from()!=source){
            path.push(cameFrom[v]);
            v = cameFrom[v].from() ; 
        }
        path.push(cameFrom[v]); 
        return path ; 
    }
    
    public double distTo(int v){
        return distTo[v] ; 
    }
    
     private void fill(double ar[] , double value){
       for(int i = 0 ; i < distTo.length ; ++i){
           ar[i] = Double.POSITIVE_INFINITY ; 
       } 
    }
    public static void main(String args[]) throws FileNotFoundException{
    //    Scanner in = new Scanner(new FileReader("/home/abdo/Desktop/largeSPT_Test.txt")) ;
       Scanner in = new Scanner(System.in) ;
       int v = in.nextInt() ; 
       int e = in.nextInt() ; 
       
       long s1 = System.currentTimeMillis() ; 
       DirectedWeightedGraph g = new DirectedWeightedGraph(v) ;
       for(int i =0 ; i < e ; ++i){
           int from = in.nextInt() ; 
           int to = in.nextInt() ; 
           double weight = in.nextDouble() ;
       g.addEdge(new DirectedEdge(from , to  , weight ));
       }
       long s2 = System.currentTimeMillis() ; 
       
       AcyclicSP test = new AcyclicSP(g,0) ; 
       
       long s3 =System.currentTimeMillis()  ; 
       double totalWeight =  0 ; 
       for(int i = 0; i < g.getVertexNumber() ; ++i){
         //  System.out.println(test.distTo(i));
         if(test.hasPathTo(i)) 
          totalWeight += test.distTo(i) ; 
       }
       System.out.println("\n--------------------------\n") ; 
       System.out.println(totalWeight) ; 
       
            System.out.println("graph time: "+(s2-s1)+" ms") ; 
            System.out.println("sp time: "+(s3-s2)+" ms") ; 
    }
}
