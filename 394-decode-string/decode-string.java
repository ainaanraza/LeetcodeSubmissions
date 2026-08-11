class Solution {
    public String decodeString(String s) {
        Stack<String> strst=new Stack<>();
        Stack<Integer> intst=new Stack<>();

        int num=0;
        String str="";

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='['){
                intst.push(num);
                strst.push(str);

                num=0;
                str="";
            }
            else if(ch==']'){
                int len=intst.pop();
                String prev=strst.pop();

                String tmp="";
                for(int j=0;j<len;j++){
                    tmp+=str;
                }
                str=prev+tmp;
            }
            else{
                str+=ch;
            }
        }
        return str;
        
    }
}