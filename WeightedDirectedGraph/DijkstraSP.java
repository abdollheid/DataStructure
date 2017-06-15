
package WeightedDirectedGraph;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import learning_datastrucure.IndexedMinProrityQueue;
import learning_datastrucure.Stack;


public class DijkstraSP {
    private double distTo[] ; 
    private DirectedEdge cameFrom[] ; 
    private int source ; 
    
    
    public DijkstraSP(DirectedWeightedGraph graph , int source)throws Exception{
        this.source = source ; 
       distTo = new double[graph.getVertexNumber()]; 
       cameFrom = new DirectedEdge[graph.getVertexNumber()]; 
       fill(distTo , Double.POSITIVE_INFINITY);
       
       IndexedMinProrityQueue<Double> pq = new IndexedMinProrityQueue<>(graph.getVertexNumber());
       distTo[source] = 0 ;
       
       for(int i = 0 ; i < graph.getVertexNumber() ; ++i){
           if(i == source)
               pq.insert(0d, i);
           else{
           pq.insert(Double.POSITIVE_INFINITY, i);
           }
       }
       
       while(!pq.isEmpty()){
           int vertex = pq.vertexInPosition(1) ;  // smallest Vertext Weight
           pq.delMin() ;
           for(DirectedEdge e : graph.adj(vertex)){
               if(distTo[e.to()] > distTo[e.from()] + e.getWeight()){
                   distTo[e.to()] = distTo[e.from()] + e.getWeight() ;
                   cameFrom[e.to()] = e ; 
                   pq.decreaseKey(e.to(), distTo[e.to()]);
               }
           }
           
       }
       
       
       
       
       
       
     
       
    }
    
    
    public double distTo(int v){
        return distTo[v] ; 
    }
    
    public boolean hasPathTo(int v){
        return distTo[v] != Double.POSITIVE_INFINITY  ;
    }
    
    public Iterable<DirectedEdge> pathTo(int v){
        ArrayList<DirectedEdge> edgs = new ArrayList<DirectedEdge>(); 
        while(cameFrom[v].from()!=source){
            edgs.add(cameFrom[v]) ; 
            v = cameFrom[v].from() ; 
        }
        edgs.add(cameFrom[v]);
        return edgs ; 
    }
    
    
    
    private void fill(double ar[] , double value){
       for(int i = 0 ; i < distTo.length ; ++i){
           ar[i] = Double.POSITIVE_INFINITY ; 
       } 
    }
    
    
    
    public static void main(String args[])throws Exception{
        /*
        8
15
4 5 0.35
5 4 0.35
4 7 0.37
5 7 0.28
7 5 0.28
5 1 0.32
0 4 0.38
0 2 0.26
7 3 0.39
1 3 0.29
2 7 0.34
6 2 0.40
3 6 0.52
6 0 0.58
6 4 0.93
        */
        java.util.Scanner input = new java.util.Scanner(new FileReader("/home/abdo/Desktop/largeSPT_Test.txt")) ; 
        int v = input.nextInt() ; 
        int e = input.nextInt();
        long s1 = System.currentTimeMillis() ; 
        DirectedWeightedGraph test = new DirectedWeightedGraph(v);
        for(int i = 0 ; i < e; ++i){
            int from = input.nextInt() ;
            int to = input.nextInt() ; 
            double weight = input.nextDouble() ;
            test.addEdge(new DirectedEdge(from , to , weight));
        }
        long s2 = System.currentTimeMillis() ; 
        DijkstraSP sp =new DijkstraSP(test , 0 ) ;
        long s3 = System.currentTimeMillis() ; 
       
        double totalWeight = 0 ; 
        for(int i = 0 ; i < v ; ++i){
//            System.out.print("0:"+i+"("+sp.distTo(i)+") ");
            if(sp.hasPathTo(i))
                totalWeight += sp.distTo(i); 
//            for(DirectedEdge edgs :sp.pathTo(i) ){
//                System.out.print(edgs.from()+"->"+edgs.to()+" "+edgs.getWeight()+"\t");
//            }
//            System.out.println();
        }
        System.out.println(totalWeight);
        
            System.out.println(totalWeight) ; 
            System.out.println("graph time: "+(s2-s1)+" ms") ; 
            System.out.println("sp time: "+(s3-s2)+" ms") ; 
        
        /*
        568310.4639856056
        graph time: 82326 ms
        sp time: 9411 ms
            
        568310.4639856056
        graph time: 72349 ms
        sp time: 1782 ms
*/
        
    }
    
}
