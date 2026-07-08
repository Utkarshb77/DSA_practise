class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = -1;
        for(int i: piles) hi = Math.max(i , hi);
        int ans = hi;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(check( piles , mid , h)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
    public boolean check(int[] arr , int k , int h){
        long hours = 0;
        for(int i: arr){ // time = dist/speed
            hours = hours + (i / k ); // devide se we found minimum hours required  
            if( i % k != 0 ) hours++; // if extra time is required 1 hr added.
        }
        return hours <= h;
    }
}