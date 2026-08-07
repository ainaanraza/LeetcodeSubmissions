class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] lse=new int[n];
        int[] rse=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) lse[i]=0;
            else lse[i]=st.peek()+1;
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) rse[i]=n-1;
            else rse[i]=st.peek()-1;
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<n;i++){
            maxarea=Math.max(maxarea, heights[i]* (rse[i]-lse[i]+1));
        }
        return maxarea;
    }
}