class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        int sum = 0;
        while(n > 0){
            int a = n % 10;
            sum += a;
            if( a != 0){
                ans = (ans*10) + a;
            }
            n = n/10;
        }
        long aaa = 0;
        while(ans > 0){
            long a = ans % 10;
            aaa = (aaa*10) + a;
            ans /= 10;
        }
        return aaa * sum; 
    }
}