class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] arr = new int[n];
        int i = 0;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        while(i<n){
            q.add(i);
            i++;
        }
        int x = 0;
        while(!q.isEmpty()){
            int idx = q.remove();
            arr[idx] = deck[x++];
            if(q.size() > 0) q.add(q.remove());
        }
        return arr;
    }
}
// 2,3,5,7,11,13,17
// Queue: 0,1,2,3,4,5,6
// index 0 is getting processed , put 2 at 0 , queue : 2,3,4,5,6,1
// index 2 is getting processed, put 3 at 2, queue: 4,5,6,1,3
// index 4 is getting processed, put 5 at 4, queue: 6,1,3,5
// index 6 is getting processed, put 7 at index 6, queue: 3,5,1
// index 3 is getting processed, put 11 at index 3, queue: 1,5
// index 1 is getting processed, put 13 at index 1, queue: 5
// index 5 is getting process, put 17 at index 5