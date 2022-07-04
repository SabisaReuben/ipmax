import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    /**
     *  Starting with a 1-indexed array of zeros and a list of operations,
     *  for each operation add a value to each the array element between two given indices,
     *  inclusive. Once all operations have been performed,
     *  return the maximum value in the array
     *
     *     a b k
     *     1 5 3
     *     4 8 7
     *     6 9 1
     *     Add the values of  between the indices  and  inclusive:
     *     index->	 1 2 3  4  5 6 7 8 9 10
     * 	        [0,0,0, 0, 0,0,0,0,0, 0]
     * 	        [3,3,3, 3, 3,0,0,0,0, 0]
     * 	        [3,3,3,10,10,7,7,7,0, 0]
     * 	        [3,3,3,10,10,8,8,8,1, 0]
     * 	        The largest value is  after all operations are performed.
     * @param n The number of elements in a one index array
     * @param queries The operation to perform the array
     * @return Return the maximum number in the array
     */
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // create an array of length n
        // fill the array with 0 values
        // loop through the query to obtain query operation
        // get the start index and end index and k (value to be added to index values)
        // from the start_index,add the value k to the current value up to  end_index
        // add array to the SortedSet and return the max value

        int[] array = new int[n+1];

        for(int i=0; i<=n; i++) array[i]=0;

        for (int j=0; j<queries.size();j++) {
            int start_index =  queries.get(j).get(0);
            int end_index =  queries.get(j).get(1);
            int k = queries.get(j).get(2);
            //if(start_index>end_index) continue;
            update(array, start_index, end_index, k);
        }
        Arrays.sort(array);
        return array[n];
    }

    public static void update(int [] arr, int start, int end, int value) {

        int length = (end-start);
        int mid=start+((length)/2);
        if ( start==end ) return;
        update(arr, start, mid, value);
        update(arr, (mid+1), end, value);

        for(int i=start+1; i<=end;i++)
            arr[i]=arr[i]+value;
        System.out.println();

    }
}