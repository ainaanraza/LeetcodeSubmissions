class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common=strs[0];
        int n=strs.length;
        if(strs.length==0){
            return "";
        }
        for(int i=1;i<n;i++){
            String s=strs[i];
            String tmp="";
            int j=0;
            while(j<s.length() && j<common.length() && s.charAt(j)==common.charAt(j)){
                tmp=tmp+s.charAt(j);
                j++;
            }
            common=tmp;
        }
        return common;
    }
}