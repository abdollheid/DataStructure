package learning_datastrucure;


public class QuickFind {

    private int size;
    private int id[],sizes[];
   

    
    public QuickFind(int size){
       
            this.size = size;
            id=new int [size];
            sizes=new int [size];
            for (int i = 0; i < size; ++i) {
                id[i] = i;
                
            }
        
    }

    public boolean isConnected(int a, int b) {
        if (id[a] == id[b]) {
            return true;
        } else {
            return false;
        }
    }

    public void conncet(int a, int b) {
        if (isConnected(a, b)) {
            return;
        } else {
            int bValue = id[b];
            for (int i = 0; i < size; ++i) {
                if (id[i] == bValue) {
                    id[i] = id[a];
                    ++sizes[i];
                }
            }
        }
    }
    
  

    
    
    public void printConnectedNumbers(){
      for (int i=0 ; i<size ; ++i ){
          boolean once=false;
          for (int x=0;x<size ; ++ x) {
              if (id [x]==i){
                  System.out.print(x+", ");
                  once=true;
              }
          }
          if(once)
          System.out.println();
      }
    }

}
