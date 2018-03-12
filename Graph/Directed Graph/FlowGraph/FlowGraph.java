/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlowGraph;

import java.util.ArrayList;


public class FlowGraph {
    private ArrayList<FlowEdge> verticies []; 
    private final int vertexSize  ; 
    
    public FlowGraph(int vertexSize){
        this.vertexSize = vertexSize ; 
        verticies = new ArrayList[vertexSize] ; 
        
        for(int i = 0 ; i < vertexSize ; ++i)
            verticies[i] = new ArrayList<FlowEdge>() ; 
        
    }
    
    
    public void addEdge(FlowEdge e) {
        verticies[e.to()].add(e) ; 
        verticies[e.from()].add(e) ; 
    }
    
    
    public int vertexSize(){
        return vertexSize ; 
    }
    
    public Iterable<FlowEdge> adj(int v){
        return verticies[v] ; 
    }
    
}
