package learning_datastructure.WightedUndirectedGraph;

import java.util.ArrayList;
import learning_datastrucure.PriorityQueue_Min;


public class MST_Prim {
    private double mstWeight ; 
    private ArrayList<Edge> mst ; 
   
    public MST_Prim(UndirectedWeightedGraph graph)throws Exception{
        mst = new ArrayList<Edge>();
        
        
        PriorityQueue_Min<Edge> pq = new PriorityQueue_Min<>(graph.getEdgeNumber()); 
        boolean connected[] = new boolean [graph.getVertexNumber()] ; 
        connected[0] = true ; 
        int lastVertex = 0 ; 
        
        for(int i =0 ; i <graph.getVertexNumber()-1 ; ++i){
            for(Edge edg : graph.adj(lastVertex)){
                if(connected[edg.either()]&&connected[edg.other(edg.either())])
                    continue ;
                pq.insert(edg);
            }
            
            Edge temp = pq.delMin() ; 
            while(connected[temp.either()]&&connected[temp.other(temp.either())]){
                temp = pq.delMin() ; 
            }
            if(!connected[temp.either()]){
                lastVertex = temp.either();
           
            }else{
                lastVertex = temp.other(temp.either()) ;
            }
            connected[lastVertex] = true ;
            mst.add(temp) ;
            mstWeight+=temp.getWeight() ;
            
        }
        
    }
    
    
    
    public Iterable<Edge> edges(){
        return mst;
    }
    public double getTotalWeight(){
        return mstWeight ;
    }
}



