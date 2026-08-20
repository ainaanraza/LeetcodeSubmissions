class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st=new Stack<>();
        int n=logs.length;
        int i=0;
        while(i<n){
           
            if(logs[i].equals("../")){
                if(!st.isEmpty()){
                st.pop();
                }
            }
            else if(logs[i].equals("./")){
            }
            else{
                st.push(logs[i]);
            }
            i++;
        }
        return st.size();
    }
}