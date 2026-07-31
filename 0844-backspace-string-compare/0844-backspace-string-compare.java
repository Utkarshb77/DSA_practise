class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if( c ==  '#' ){
                if(s1.length() == 0) continue;
                s1.deleteCharAt(s1.length()-1);
            }
            else s1.append(c);
        }
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if( c == '#' ){
                if(t1.length() == 0) continue;
                t1.deleteCharAt(t1.length()-1);
            }
            else t1.append(c);
        }
        String s2 = s1.toString();
        String t2 = t1.toString();
        if( s1.length() == 0 && t1.length() == 0) return true;
        return s2.equals(t2);
    }
}