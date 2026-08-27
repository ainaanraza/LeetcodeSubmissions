class Solution {
    public int[] searchRange(int[] nums, int target) {
         int lo=0;
         int hi=nums.length-1;
         int i=-1;
         int j=-1;
         while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target){
                i=mid;
                hi=mid-1;
                

            }
            else if(nums[mid]<target){
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
         }
         lo=0;
         hi=nums.length-1;
         while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target){
                j=mid;
                lo=mid+1;
                

            }
            else if(nums[mid]<target){
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
         }
         return new int[]{i,j};
    }
}