// Optimal Approach (not mine rn)
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            ans += expand(s, i, i);
            // Even length palindrome
            ans += expand(s, i, i + 1);
        }
        return ans;
    }
    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
// Working but not the optimal approach
// class Solution {
//     public int countSubstrings(String s) {
//         int ans = 0;
//         for(int i=0;i<s.length();i++){
//             for(int j=i;j<s.length();j++){
//                 String sub = s.substring(i , j+1);
//                 if(check(sub)) ans++;
//             }
//         }
//         return ans;
//     }
//     public static boolean check(String s){
//         int i=0;
//         int j=s.length()-1;
//         while(i<=j){
//             if(s.charAt(i) != s.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }