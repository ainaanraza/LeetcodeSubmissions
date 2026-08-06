class Solution {
    public int appendCharacters(String s, String t) {
        int slen=s.length();
        int tlen=t.length();
        int i=0;
        int j=0;
        int output=0;
        while(i<slen && j<tlen){
            char sch=s.charAt(i);
            char tch=t.charAt(j);
            if(sch==tch){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return tlen-j;
    }
}