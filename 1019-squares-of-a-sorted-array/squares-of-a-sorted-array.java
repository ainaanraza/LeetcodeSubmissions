class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
       int i=0;
       int j=n-1;
       int[] result=new int[n];
       int idx=n-1;
       while(i<=j){
        int left=nums[i]*nums[i];
        int right=nums[j]*nums[j];
        if(left>=right){
            result[idx--]=left;
            i++;
        }
        else if(right>left){
            result[idx--]=right;
            j--;
        }
       }
       return result;

    }
}