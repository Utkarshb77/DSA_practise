class Solution {
    public String smallestPalindrome(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }
        StringBuilder ss = new StringBuilder();
        for(int i=0;i<26;i++){
            int val = arr[i] / 2;
            arr[i] = arr[i] % 2;
            while(val > 0) {
                ss.append( (char) ( i + 'a'));
                val--;
            }
        }
        String rev = new String(ss.reverse());
        ss.reverse();
        for(int i=0;i<26;i++){
            if(arr[i] == 1) {
                ss.append( (char) ( i + 'a'));
            }
        }
        System.out.print(ss + " ");
        System.out.print(rev);
        ss.append(rev);
        return ss.toString();
    }
}