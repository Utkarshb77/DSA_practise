class Solution {
    public int minBishopMoves(int[] sc, int[] tar) {
        int a1 = sc[0];
        int a2 = sc[1];
        int b1 = tar[0];
        int b2 = tar[1];
        if( ((a1-b1) % 2 == 0) && ((a2-b2) % 2 != 0) ) return -1;
        else if( ((a1-b1) % 2 != 0) && ((a2-b2) % 2 == 0) ) return -1;
        else if( Math.abs((a1-b1)) == Math.abs((a2-b2)) ) return 1;
        return 2;
    }
}