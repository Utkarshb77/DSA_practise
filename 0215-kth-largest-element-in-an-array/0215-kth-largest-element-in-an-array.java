class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // This is min heap ( for max-heap do: new PriorityQueue<>(Collections.reverseOrder())
        // Add the first k elements to the min-heap  
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
         // Process the remaining elements in the nums array  
        for(int i=k;i<nums.length;i++){
            if(nums[i] > pq.peek()){ // If the current number is larger than the root of the min-heap  
             // Replace the root with the current number  
                pq.remove();  // Remove the smallest element 
                pq.add(nums[i]); // Add the current no.
            }
        }
        // The root of the min-heap is the k-th largest element 
        return pq.remove();
    }
}