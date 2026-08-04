class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] arr=new int[n1];
        int arridx=0;
        for(int i=0;i<n1;i++ ){
            Stack<Integer> st=new Stack<>();
            for(int j=n2-1;j>=0;j--){
                if(nums1[i]==nums2[n2-1]) arr[arridx]=-1;
                else if(st.isEmpty()) st.push(nums2[j]);
                else if(nums1[i]!=nums2[j]){
                    st.push(nums2[j]);
                }
                else if(nums1[i]==nums2[j]){
                    while(!st.isEmpty() && st.peek()<nums2[j]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        arr[arridx]=-1;
                    }
                    else{
                        arr[arridx]=st.peek();
                    }
                }
            }
            arridx++;
        }
        return arr;
    }
}