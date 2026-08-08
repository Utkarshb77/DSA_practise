class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if( s1.length() > s2.length()) return false;
        int[] freq = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[ s1.charAt(i) - 'a']++;
        }
        int windowsize = s1.length();
        for(int i=0;i<windowsize;i++){
            freq[ s2.charAt(i) - 'a']--;
        }
        if( check(freq)) return true;
        for(int i=windowsize;i<s2.length();i++){
            char c = s2.charAt(i);
            char del = s2.charAt(i-windowsize);
            freq[c-'a']--;
            freq[del-'a']++;
            if(check(freq)) return true;
        }
        return false;
    }
    public static boolean check(int[] freq){
        for(int x : freq){
            if( x != 0) return false;
        }
        return true;
    }
}