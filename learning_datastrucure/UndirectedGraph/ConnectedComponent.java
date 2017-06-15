/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_datastrucure.UndirectedGraph;


public class ConnectedComponent {
    private UndirectedGraph graph ; 
    public int id[] , ID ;
    private boolean marked[]; 
    
    public ConnectedComponent(UndirectedGraph g){
        id = new int [g.getVertexNumber()] ; 
        marked = new boolean [id.length] ; 
        graph = g ;
        for(int i = 0 ; i < id.length ; ++i){
            if(!marked[i]){
                dfs(i , ID) ;
                ++ID ; 
            }
        }
        
    }
    
    public boolean connected(int v1 , int v2){
        return id[v1] == id[v2] ;
    }
    
   public int count (){
       return ID ; 
   }
    
   public int id(int v){
       return id[v] ; 
   }
    
     
    private void dfs(int workingNumber , int idNumber){
        marked[workingNumber] = true ;
        id[workingNumber] = idNumber ; 
        
        for(int i : graph.adj(workingNumber)){
            if(!marked[i]){
                dfs(i , idNumber);
            }
        }
    }



}