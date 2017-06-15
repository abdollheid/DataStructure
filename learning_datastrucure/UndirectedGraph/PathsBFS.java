/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_datastrucure.UndirectedGraph;

import learning_datastrucure.Queue;
import learning_datastrucure.Stack;

/**
 *
 * @author abdo
 */
public class PathsBFS {
    private UndirectedGraph graph ; 
    private int  from[] , sourceVertex;
    private boolean marked[] ; 
    
    public PathsBFS(UndirectedGraph g , int sourceVertex){
        this.sourceVertex = sourceVertex ; 
        this.graph = g ;
        from = new int [graph.getVertexNumber()] ; 
        marked = new boolean [graph.getVertexNumber()] ; 
        BFS();
                
    }
    public boolean hasPathTo(int Vertex){
        return marked[Vertex] ; 
    }
    
     public Iterable<Integer>pathTo(int vertex){
        Stack <Integer> stack = new Stack<>() ;
        if(!hasPathTo(vertex)){
            stack.push(-1);
            return stack ; 
        }
        do{
            stack.push(vertex);
            vertex = from[vertex] ; 
        }while(vertex!=sourceVertex);
        
        return stack  ;
    }
    
    private void BFS(){
        Queue<Integer> queue = new Queue<Integer>() ;
        queue.push(sourceVertex);
        marked[sourceVertex] = true  ; 
        
        for(Integer i : queue){
            for(Integer x  : graph.adj(i)){
                if(!marked[x]){
                    queue.push(x);
                    marked[x] = true ; 
                    from[x] = i ; 
                    
                }
            }
            
        }
    }
}
