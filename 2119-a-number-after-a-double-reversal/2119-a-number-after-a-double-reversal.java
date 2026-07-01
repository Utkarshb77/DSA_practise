class Solution {
    public boolean isSameAfterReversals(int num) {
        if( num < 10) return true;
        // int last = 0;
        // int n = num;
        // while(n > 0){
        //     last = n % 10;
        //     n = n/10;
        // }
        if(num % 10 == 0) return false;
        return true;
    }
}