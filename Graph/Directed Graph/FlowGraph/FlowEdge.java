public class FlowEdge {
    private final int from , to ; 
    private final double capacity ; 
    private double flow ; 
    
    
    public FlowEdge(int from , int to , double  capacity){
        this.from = from ; 
        this.to = to ; 
        this.capacity = capacity ; 
    }
    
    
    public int from(){
        return from ; 
    }
    
    public int to(){
        return to ; 
    }
    
    public double capacity(){
        return this.capacity ; 
    }
    
    
    public double flow(){
        return this.flow ; 
    }
    
    public int other(int vertex)throws Exception{
        if(vertex == from) return to ;
        if(vertex == to) return from ; 
        
        throw new Exception("bad vertex input") ;
    }
    
    
    public double residualCapacityTo(int vertex)throws Exception{
        if (vertex == from) 
            return  flow ; 
      
        if(vertex == to )
            return capacity - flow ; 
        
        throw new Exception("bad vertex input") ; 
    }
    
    
    public void addResidualFlowTo(int vertex , double delta){
        
        if(vertex == to)
            flow += delta ; 
        
        if(vertex == from)
            flow -= delta  ; 
        
    }
}

