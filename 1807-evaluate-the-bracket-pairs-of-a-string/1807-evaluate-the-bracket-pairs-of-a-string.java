class Solution {
    public String evaluate(String s, List<List<String>> know) {
        HashMap<String , String > hm = new HashMap<>();
        for(int i=0;i<know.size();i++){
            List<String> ls = know.get(i);
            hm.put(ls.get(0) , ls.get(1));
        }
        StringBuilder ss = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                StringBuilder kkey = new StringBuilder();
                for(int j=i+1;j<s.length();j++){
                    if( s.charAt(j) == ')') {
                        i=j;
                        break;
                    }
                    kkey.append(s.charAt(j));
                }
                String val = kkey.toString();
                if(hm.containsKey(val)){
                    ss.append(hm.get(val));
                }else{
                    ss.append("?");
                }
            }
            else{
                ss.append(s.charAt(i));
            }
        }
        return ss.toString();
    }
}