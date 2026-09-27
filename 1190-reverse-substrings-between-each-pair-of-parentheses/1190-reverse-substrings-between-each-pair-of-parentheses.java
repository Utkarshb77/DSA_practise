class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                StringBuilder ss = new StringBuilder();
                while(!st.isEmpty()){
                    char ch = st.pop();
                    if(ch == '(') break;
                    ss.append(ch);
                } 
                for(int j=0;j<ss.length();j++){
                    st.push(ss.charAt(j));
                }
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}