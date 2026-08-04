class Solution {
    public String removeDuplicates(String s) {
        String newString="";
        Stack<Character> st=new Stack<>();
        int n=s.length();
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            if(st.isEmpty()){ 
                st.push(ch);
            }
            else if(ch==st.peek()){
                st.pop();
            }
            else{
                st.push(ch);
            }
            i++;
        }
            while(!st.isEmpty()){
                newString=st.pop()+newString;
            }
        return newString;
    }
}