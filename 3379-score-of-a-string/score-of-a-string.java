class Solution {
    public int scoreOfString(String s) {
        int n=s.length();
        int[] arr=new int[n];
        int idx=0;
        for(int i=0;i<n;i++){
            for(char j='a';j<='z';j++){
                if(s.charAt(i)==j){
                    arr[idx++]=(int)j;
                }
            }
        }
        int sum=0;
        for(int i=0;i<idx-1;i++){
            sum+=Math.abs(arr[i]-arr[i+1]);
        }
        return sum;
    }
}