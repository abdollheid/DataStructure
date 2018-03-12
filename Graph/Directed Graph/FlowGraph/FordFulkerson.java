
package FlowGraph;

import java.util.Scanner;
import learning_datastrucure.Queue;

public class FordFulkerson {

    private boolean[] marked; // Is s->v path in residual graph?
    private FlowEdge[] edgeTo; // last edge on shortest s->v path
    private double value; // current value of maxflow

    public FordFulkerson(FlowGraph G, int s, int t) throws Exception { 
        while (hasAugmentingPath(G, s, t)) {

            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }
// Augment flow.
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }
            value += bottle;
        }
    }

    public double value() {
        return value;
    }

    public boolean inCut(int v) {
        return marked[v];
    }

    private boolean hasAugmentingPath(FlowGraph G, int s, int t) throws Exception {
        marked = new boolean[G.vertexSize()]; // Is path to this vertex known?
        edgeTo = new FlowEdge[G.vertexSize()]; // last edge on path
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true; 
        q.push(s); 
        while (!q.isEmpty()) {
            int v = q.pop();
            for (FlowEdge e : G.adj(v)) {
                int w = e.other(v);
                if (e.residualCapacityTo(w) > 0 && !marked[w]) { 
                    edgeTo[w] = e; 
                    marked[w] = true;
                    q.push(w); 
                }
            }
        }
        return marked[t];
    }


// to test FordFulkkerson algorithm
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in) ; 
        int vSize = in.nextInt() ; 
        FlowGraph G = new FlowGraph(vSize);
        
        for(int i = 0 ; i < G.vertexSize() ; ++i ){
            FlowEdge flowEdge  = new FlowEdge(in.nextInt() , in.nextInt() , in.nextDouble()) ; 
            G.addEdge(flowEdge) ; 
        }
        
        
        
        int s = 0, t = G.vertexSize() - 1;
        FordFulkerson maxflow = new FordFulkerson(G, s, t);
        
        for (int v = 0; v < G.vertexSize(); v++) {
            for (FlowEdge e : G.adj(v)) {
                if ((v == e.from()) && e.flow() > 0) {
                    System.out.println(" " + e);
                }
            }
        }
       
        System.out.println("Max flow value = " + maxflow.value());
    }
}
