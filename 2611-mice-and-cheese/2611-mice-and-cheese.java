class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        for (int i : reward2) {
            ans += i;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        for(int i=0;i<reward1.length;i++){
            pq.add(new Pair(i , reward1[i] - reward2[i]));
        }
        while(k-- > 0){
            Pair p = pq.remove();
            ans += p.val;
        }
        return ans;
    }
}
class Pair{
    int idx;
    int val;
    Pair(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}