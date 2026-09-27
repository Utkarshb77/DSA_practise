class Solution {
    public boolean canTransform(int[] src, int[] tar) {
        long sum1= 0;
        long sum2= 0;
        for(int i : src) sum1+=i;
        for(int i: tar) sum2+= i;
        return sum1 == sum2;
    }
}