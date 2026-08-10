class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] arr = new int[26];
        for(int i=0;i<s1.length();i++) arr[ s1.charAt(i) - 'a']++ ;
        int windowsize = s1.length();
        for(int i=0;i<windowsize;i++) arr[s2.charAt(i)-'a']--;
        if(allzero(arr)) return true;
        for(int i=windowsize;i<s2.length();i++){
            int idx1 =s2.charAt(i)-'a';
            int idx2 = s2.charAt(i-windowsize)  - 'a';
            arr[idx1]--;
            arr[idx2]++;
            if(allzero(arr)) return true;
        }
        return false;
    }
    public static boolean allzero(int[] arr){
        for(int i : arr) if(i != 0) return false;
        return true;
    }
}