/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.WeightedDirectedGraph;



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import learning_datastrucure.Queue;
import learning_datastrucure.Stack;

/**
 *
 * @author abdo
 */
public class BellmanFordSPNegativeWeight {
    private int source  ;
    private double distTo[] ;  
    private DirectedEdge cameFrom[] ;
    private DirectedWeightedGraph g ; 
    
    
    public BellmanFordSPNegativeWeight( DirectedWeightedGraph g , int source  )throws Exception{
        
        
        if(g.hasNegativeCycle(source)){
            throw new Exception("the graph has as negative cycle in it ") ; 
        }
//        
        
        this.source = source ; 
        this.g = g ; 
       
        distTo = new double [g.getVertexNumber()] ; 
        cameFrom = new DirectedEdge [g.getVertexNumber()] ; 
        
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[source] = 0 ; 
        
        
        Queue<Integer> vs = new Queue<>() ;
        boolean onQueue[] = new boolean [g.getVertexNumber()] ; 
        
        vs.push(source); 
        onQueue[source] = true ; 
        
        
        
        
        
        while(!vs.isEmpty()){
            int vTemp = vs.pop() ; 
            onQueue[vTemp] = false ; 
            relax(vTemp , onQueue , vs) ;
                    
    }
        
        
    }
    
    private void relax(int vertex , boolean onQueue[] , Queue<Integer> q){
        for (DirectedEdge e : g.adj(vertex)){
            
            if(distTo[e.from()] + e.getWeight()  < distTo[e.to()] ){
                distTo[e.to()] = distTo[e.from()] + e.getWeight() ; 
                cameFrom [e.to()] = e ;  
                
                if(!onQueue[e.to()]){
                    q.push(e.to());
                    onQueue[e.to()] = true ; 
                }
            }
        }
    }
    
    
    public double distTo(int v){
        return distTo[v]  ;
    }
    
    
    public Iterable<DirectedEdge> getPath(int v){
        
        
        Stack <DirectedEdge>   s = new Stack<>() ; 
        DirectedEdge temp = cameFrom[v] ; 
        
        while(temp.from() != source){
            s.push(temp);
            temp = cameFrom[temp.from()] ; 
        }
        
        s.push( temp);
        
        
        return s ; 
        
    }
    
    
    
    
    public static void main(String args[])throws Exception{
         
         
         Scanner input = new Scanner(System.in) ; 
         
         int v = input.nextInt() ; 
//         int v = 290 ; 
         DirectedWeightedGraph g  = new DirectedWeightedGraph(v);
//         DirectedWeightedGraph g  = printG(v);
         
         int e = input.nextInt() ; 
//         
         for(int i = 0  ; i < e ; ++i ){
             g.addEdge(new DirectedEdge(input.nextInt() , input.nextInt() , input.nextDouble()));
         }
         
         long djt0 = System.currentTimeMillis() ; 
         DijkstraSP dj = new DijkstraSP(g ,  0  ); 
         
         long blt0 = System.currentTimeMillis() ; 
         BellmanFordSPNegativeWeight bl = new BellmanFordSPNegativeWeight(g , 0 ) ;
         long blt1 = System.currentTimeMillis() ; 
         
         System.out.println(dj.distTo(v  - 1)  + "\tdg in "+(blt0 - djt0) + "ms" ) ;
         System.out.println(bl.distTo(v  - 1)  + "\tbl in "+(blt1 - blt0) + "ms") ;
         
         
//         g.addEdge(new DirectedEdge(0 , 1 , 1));
//         g.addEdge(new DirectedEdge(1 , 2 , 10));
//         g.addEdge(new DirectedEdge(2 , 3 , 100));
//         g.addEdge(new DirectedEdge(1 , 3 , 1_000));
//         g.addEdge(new DirectedEdge(3 , 4 , 10_000));
//         g.addEdge(new DirectedEdge(4 , 5 , 100_000));
//         g.addEdge(new DirectedEdge(5 , 3 , 1_000_000));
//         g.addEdge(new DirectedEdge(5 , 3 , 1_000_000));
//         g.addEdge(new DirectedEdge(3 , 6 , 10_000_000));
//         g.addEdge(new DirectedEdge(6 , 1 , 100_000_000));
//         g.addEdge(new DirectedEdge(4 , 2 , 1_000_000_000));
         
         
         
         
         
//         printG() ; 
         
    }
    
    
    
    public static DirectedWeightedGraph printG(int v ){
       Random r = new Random(1) ; 
       
       System.out.println(v);
      DirectedWeightedGraph g  = new DirectedWeightedGraph(v) ;
       
       
       
       for(int i = 0 ; i < v ; ++i){
           for(int x = i + 1 ; x < v ;++x){
               
               g.addEdge(new DirectedEdge(i , x , r.nextInt(1000)));
           }
       }
       
        return g ; 
        
    }
    
    
    
    
}

