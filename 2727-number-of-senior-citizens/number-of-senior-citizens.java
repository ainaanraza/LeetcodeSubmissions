class Solution {
    public int countSeniors(String[] details) {
        int n=details.length;
        int count=0;
        for(int i=0;i<n;i++){
            String s=details[i];
            int num=0;
            num=num*10+(s.charAt(11)-'0');
            num=num*10+(s.charAt(12)-'0');
            if(num>60){
                count++;
            }

        }
        return count;
    }
}