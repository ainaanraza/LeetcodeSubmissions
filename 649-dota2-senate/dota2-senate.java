class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> R=new ArrayDeque<>();
        Deque<Integer> D=new ArrayDeque<>();

        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                R.addLast(i);
            }
            else{
                D.addLast(i);
            }
        }
        int n=senate.length();
        while(!R.isEmpty() && !D.isEmpty()){
            if(R.peekFirst()<D.peekFirst()){
                D.pollFirst();
                R.addLast(R.pollFirst()+n);

            }
            else{
                R.pollFirst();
                D.addLast(D.pollFirst()+n);
            }
        }
        if(!R.isEmpty()) return "Radiant";
        else return "Dire";

    }
}