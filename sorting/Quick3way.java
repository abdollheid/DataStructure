
package learning_datastrucure.sortion;

import learning_datastrucure.Shuffle;

public class Quick3way {

    // This class should not be instantiated.
    private Quick3way() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
       Shuffle.start(a);
        sort(a, 0, a.length - 1);
      
    }

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    private static void sort(int[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo;
        while (i <= gt) {
       
            if      ( a[i]<v ) exch(a, lt++, i++);
            else if ( a[i]>v) exch(a, i, gt--);
            else              i++;
        }

     
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
        
    }



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }



   

    /**
     * Reads in a sequence of strings from standard input; 3-way
     * quicksorts them; and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
 

}
