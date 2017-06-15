package learning_datastrucure.UndirectedGraph;

import java.util.Iterator;
import learning_datastrucure.Stack;

public class PathsDFS {
    private UndirectedGraph graph ; 
    private boolean  marked [] ; 
    private int from[] , source; 
    
    
    public PathsDFS(UndirectedGraph g , int source){
        graph = g  ;
        this.source =source ;
        marked = new boolean [g.getVertexNumber()] ; 
        from = new int [g.getVertexNumber()] ;
        dfs(source , source) ; 
    }
    
    public boolean hasPathTo(int vertex){
        return marked[vertex] ; 
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
        }while(vertex!=source);
        
        return stack  ;
    }
    
    private void dfs(int workingVertex , int parent){
 
        
        marked [workingVertex] = true ; 
        from[workingVertex] = parent  ;
        
        for(Integer i : graph.adj(workingVertex)){
            if(!marked[i])
            dfs( i , workingVertex ) ; 
        }
        
        
        
    }

//    @Override
//    public Iterator iterator() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    private class IteratorCopy implements Iterator{
//
//        @Override
//        public boolean hasNext() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public Object next() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//        
//    }
    
}
