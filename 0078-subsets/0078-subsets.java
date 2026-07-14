class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lls = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        helper(0,nums , lls , ls);
        return lls;
    }
    // Backtracking using a for loop
    // At each recursive call, store the current subset.
    // Then, try adding every possible element starting from 'idx'.
    public static void helper(int idx, int[] arr, List<List<Integer>> lls, List<Integer> ls) {
        // Store the current subset
        lls.add(new ArrayList<>(ls));
        // Explore all possible choices starting from 'idx'
        for (int i = idx; i < arr.length; i++) {
            // Choose the current element
            ls.add(arr[i]);
            // Recur for the remaining elements
            helper(i + 1, arr, lls, ls);
            // Backtrack: remove the last chosen element
            ls.remove(ls.size() - 1);
        }
    }
    // Recursion using Take / Not Take
     /*
    public static void helper(int idx, int[] arr, List<List<Integer>> lls, List<Integer> ls) {
        // Base case: all elements have been considered
        if (idx == arr.length) {
            lls.add(new ArrayList<>(ls));
            return;
        }
        // Take the current element
        ls.add(arr[idx]);
        helper(idx + 1, arr, lls, ls);
        // Backtrack
        ls.remove(ls.size() - 1);
        // Skip the current element
        helper(idx + 1, arr, lls, ls);
    }
    */
}