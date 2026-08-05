class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx=0;
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            boolean get=false;
            for(int j=idx;j<t.length();j++){
                char ch2=t.charAt(j);
                if(ch1==ch2){
                    get=true;
                    idx=j+1;
                    break;
                }
            }
            if(!get){
                return false;
            }
        }
        return true;
    }
}