class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[] result=new int[n];
        int i=0;
        int j=1;
        while(i<n){
            if(j<n && prices[j]<=prices[i]){
                result[i]=prices[i]-prices[j];
                i++;
                j=i+1;
            }
            else if (j == n) {
                result[i] = prices[i];
                i++;
                j = i + 1;
            }
            else{
                j++;
            }

        }
        return result;
    }
}