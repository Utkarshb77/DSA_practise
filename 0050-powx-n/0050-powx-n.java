class Solution {
    public double myPow(double x, int N) {
        if( N == 0) return 1;
        long n = N;
        if( n < 0){
            x = 1/x;
            n = -n;
        }
        return pow(x,n);
    }
    public static double pow(double x , long n){
        if( n == 1) return x;
        double temp = pow(x , n/2);
        if(n%2==0){
            return temp*temp;
        }
        else{
            return temp*temp*x;
        }
    }
}