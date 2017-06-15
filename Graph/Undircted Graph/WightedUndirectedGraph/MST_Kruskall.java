package learning_datastructure.WightedUndirectedGraph;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import learning_datastrucure.Queue;
import learning_datastrucure.WeightedQuickUnion;


public class MST_Kruskall {
    private Queue<Edge> mst ;
    private double mstWeight ; 
    
    public MST_Kruskall(UndirectedWeightedGraph graph){
       Edge edges[] = new Edge[graph.getEdgeNumber()]; 
       mst = new Queue<Edge>();
       fillEdges(edges , graph) ; 
       Arrays.sort(edges);
       
       
       int current = 0 ; 
       WeightedQuickUnion groups = new WeightedQuickUnion(graph.getVertexNumber()) ;
       
       for(int i =0 ; i < graph.getVertexNumber() - 1 ; ++i){
           while(groups.isConnected(edges[current].either(), edges[current].other(edges[current].either()))){
               ++current ; 
           }
           mst.push(edges[current]);
           int v = edges[current].either() ; 
           int w = edges[current].other(v) ;
           mstWeight += edges[current].getWeight() ;
           groups.connect(v,w); 
           current++;
       }
        
    }
    
    public Iterable<Edge> edges(){
        return mst ; 
    }

    
    public void fillEdges(Edge edges[] , UndirectedWeightedGraph graph){
        int  i = 0 ; 
        for(Edge e : graph.edges()){
            edges[i] = e ;
            ++ i ; 
        }
    }
    
    public double getTotalWeight(){
        return mstWeight ;
    }
      public static void main(String args[])throws Exception{
//         UndirectedWeightedGraph graph = new UndirectedWeightedGraph(5) ;
//         graph.addEdge(new Edge(0,1,.4));
//         graph.addEdge(new Edge(0,4,22));
//         graph.addEdge(new Edge(1,2,.6));
//         graph.addEdge(new Edge(2,3,.7));
//         graph.addEdge(new Edge(1,4,.5));
//         
//         for(int i = 0 ; i < graph.getVertexNumber() ; ++i){
//            
//             for(Edge edg : graph.adj(i)){
//                 System.out.println(edg.either()+"-"+edg.other(edg.either())+", "+edg.getWeight()) ;
//             }
//             System.out.println("---------------------");
//         }


            
/*
 8
 16
4 5 0.35
4 7 0.37
 5 7 0.28
 0 7 0.16
 1 5 0.32
0 4 0.38
 2 3 0.17
 1 7 0.19
0 2 0.26
 1 2 0.36
 1 3 0.29
2 7 0.34
6 2 0.40
 3 6 0.52
6 0 0.58
6 4 0.93
 
*/
         // new FileReader("/home/abdo/Desktop/largeMST_TEST.txt")    for files 
         Scanner input = new Scanner(new FileReader("/home/abdo/Desktop/largeMST_TEST.txt") ); 
         int vNum = input.nextInt(); 
         int e = input.nextInt() ; 
         
         long s1 = System.currentTimeMillis(); 
         UndirectedWeightedGraph graph = new UndirectedWeightedGraph(vNum) ;
         
         for(int i = 0 ; i < e; ++i){
             int v1 = input.nextInt(); 
             int v2 = input.nextInt() ;
             double w = input.nextDouble() ;
             graph.addEdge(new Edge(v1 , v2 , w));
         }
         long s2 =System.currentTimeMillis() ;
           //System.out.println("\n\n----------------\n\n");
           
         MST_Kruskall test = new MST_Kruskall(graph); 
         long s3 = System.currentTimeMillis() ;
//         double totalWeight = 0 ; 
//         for(Edge edg : test.edges()){
//             totalWeight += edg.getWeight() ;
//             // System.out.println(edg.either()+"-"+edg.other(edg.either())+","+edg.getWeight()) ;
//         }
//         long s4 = System.currentTimeMillis() ;
         System.out.println(test.getTotalWeight());
         System.out.println("graph Construction: "+(s2-s1)+" ms");
         System.out.println("calulating MST: "+(s3-s2)+" ms");
         
//         647.6630695499812
//         graph Construction: 41720 ms
//         calulating MST: 8498 ms
     }
}


