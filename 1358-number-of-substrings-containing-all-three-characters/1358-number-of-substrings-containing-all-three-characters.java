class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int i=0;
        int[] arr = new int[3];
        for(int j=0;j<s.length();j++){
            arr[s.charAt(j) - 'a']++;
            while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
                ans += s.length() - j;
                arr[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return ans;
    }
}