class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (p1, p2) -> {
                double d1 = p1.i * p1.i + p1.j * p1.j;
                double d2 = p2.i * p2.i + p2.j * p2.j;
                return Double.compare(d2, d1);
            }
        );
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int a = points[i][0];
            int b = points[i][1];
            Pair p = new Pair(a, b);
            pq.add(p);
        }
        for (int i = k; i < points.length; i++) {
            int a = points[i][0];
            int b = points[i][1];
            double dis = Math.sqrt(a * a + b * b);
            Pair pe = pq.peek();
            double dis2 = Math.sqrt(pe.i * pe.i + pe.j * pe.j);
            if (dis < dis2) {
                pq.remove();
                pq.add(new Pair(a, b));
            }
        }
        int x = 0;
        while (!pq.isEmpty()) {
            Pair add = pq.remove();
            ans[x][0] = add.i;
            ans[x][1] = add.j;
            x++;
        }
        return ans;
    }
}
class Pair {
    int i;
    int j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}