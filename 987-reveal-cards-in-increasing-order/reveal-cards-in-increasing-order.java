class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q=new LinkedList<>();
        int n=deck.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            q.add(i);
        }
        Arrays.sort(deck);
        for(int i=0;i<n;i++){
           arr[q.poll()]=deck[i];
           q.add(q.poll());
        }
    
        return arr;
    }
}