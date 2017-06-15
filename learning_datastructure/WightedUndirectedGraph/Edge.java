
package learning_datastructure.WightedUndirectedGraph;

public class Edge implements Comparable<Edge> {
    private int v , w ; 
    private double weight ;     

    
    public Edge(int v , int w , double weight ){
        this.v = v ; 
        this.w = w ; 
        this.weight = weight ; 
    }
    
    public int either(){
        return v ;
    }
    
    public int other(int vertex){
        if(vertex ==v) return w ; 
        else return v ;
    }
    
    
    
    @Override
    public int compareTo(Edge other) {
      if(this.weight > other.getWeight())
          return 1 ; 
      else
          if(this.weight < other.getWeight())
              return -1 ;
          else
              return 0 ; 
      
    }
    
    public double getWeight(){
        return weight ; 
    }
    
}
