// class Solution {
//     public boolean isPalindrome(String s) {
//         s=s.toLowerCase();
//         char[] arr = s.toCharArray();
//         StringBuilder str = new StringBuilder();
//         for(int i=0;i<s.length();i++){
//             if((arr[i] >=48  && arr[i] <= 57 ) || (arr[i] >= 97 && arr[i] <= 122)){
//                 str.append(arr[i]);
//             }
//         }
//         int l = str.length();
//         for(int i=0;i<str.length();i++){
//             if(str.charAt(i) != str.charAt(l-1-i)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
// Recursion Code : 
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        List<Character> ls = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) { 
                ls.add(s.charAt(i));
            }
        }
        return rec( ls , 0 , ls.size()-1);
    }
    public static boolean rec( List<Character> ls , int i , int e){
        if( i >= e) return true; 
        if( ls.get(i) != ls.get(e)) return false;
        return rec( ls , i+1 , e-1); 
    }
}