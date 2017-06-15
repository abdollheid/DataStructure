package learning_datastrucure;

public class WeightedQuickUnion {

    private int id[], numberOfGroups[], rootA, rootB,maxConnectedNumber;

    public WeightedQuickUnion(int size) {
       
        id = new int[size];
        numberOfGroups = new int[size];
        for (int i = 0; i < size; ++i) {
            id[i] = i;
            numberOfGroups[i] = 1;
             }
    }

    public boolean isConnected(int a, int b) {
        rootA = getRoot(a);
        rootB = getRoot(b);
        return rootA == rootB;

    }

    private int getRoot(int n) {
        while (n != id[n]) {
            id[n]=id[id[n]];
            n = id[n];
            }
        return n;
    }

    public void connect(int a, int b) {
        int rootA=getRoot(a);
        int rootB=getRoot(b);
        
        if (rootA==rootB) {
            return;
        } else {
             

            if (numberOfGroups[rootA] > numberOfGroups[rootB]) {
                id[rootB] = id[rootA];
            
                numberOfGroups[rootA] += numberOfGroups[rootB];
                numberOfGroups[rootB]=0;
                if( numberOfGroups[rootA]>maxConnectedNumber){
                    maxConnectedNumber=numberOfGroups[rootA];
                }
               
               
            } else {
                id[rootA] = id[rootB];
                numberOfGroups[rootB] += numberOfGroups[rootA];
            
            
                   if( numberOfGroups[rootB]>maxConnectedNumber){
                    maxConnectedNumber=numberOfGroups[rootB];
                }
                 numberOfGroups[rootA]=0;
             
            }
        }
    }

    public int getGroups(int a) {
        return numberOfGroups[a];
    }
    public int getMaxConnectedElements(){
        return maxConnectedNumber;
    }
  

}
