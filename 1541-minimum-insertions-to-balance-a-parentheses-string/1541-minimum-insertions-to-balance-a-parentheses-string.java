class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') st.push('(');
            else if( i+1 < s.length() && s.charAt(i+1) == ')') {
                if(st.isEmpty()){
                    ans++;
                }
                else{
                    st.pop();
                }
                i++;
            }
            else{
                if (!st.isEmpty()) {
                    ans++;
                    st.pop();
                } else {
                    ans += 2; 
                }
            }
        }
        ans += st.size() * 2;
        return ans;
    }
}