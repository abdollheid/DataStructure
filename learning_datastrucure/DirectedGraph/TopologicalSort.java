package learning_datastrucure.DirectedGraph;

import learning_datastrucure.Queue;
import learning_datastrucure.Stack;



public class TopologicalSort {
    
    private Stack<Integer> reversedOrder ;
    private Queue<Integer> normalOrder ; 
    private boolean marked[] ;
    private DirectedGraph g ; 
    
    public TopologicalSort(DirectedGraph g){
        marked = new boolean[g.getVertexNumber()] ; 
        this.g = g ; 
        reversedOrder = new Stack<>() ; 
        normalOrder = new Queue<>() ; 
        
        for(int i = 0 ; i <g.getVertexNumber(); ++i){
            if(!marked[i]){
                dfs(i) ; 
            }
        }
    }
    
    private void dfs(int workingNumber){
        marked[workingNumber] = true ; 
        
        for(int i : g.adj(workingNumber)){
            if(!marked[i]){
                dfs(i)  ;
            }
        }
        normalOrder.push(workingNumber);
        reversedOrder.push(workingNumber);
    }
    
    public Iterable<Integer> getOrder(){
        return normalOrder; 
    }
    public Iterable<Integer> getReversedOrder(){
        return reversedOrder ; 
    }
    
    public static void main(String args []){
        
    }
    
    
}
