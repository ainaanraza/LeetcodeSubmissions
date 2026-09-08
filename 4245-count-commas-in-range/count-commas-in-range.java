class Solution {
    public int countCommas(int n) {
        int digits=0;int num=n;
        while(num>0){
            digits++;
            num=num/10;
        }
        int commas=0;
        if(digits<=3){
            return 0;
        }
        else if(digits>3 && digits<=4){
            int x=1000;
            while(x<=n){
                commas++;
                x++;
            }
        }
        else if(digits<=5){
            commas=9000;
            int x=10000;
            while(x<=n){
                commas++;
                x++;
            }
        }
        else{
            commas=99000;
            int x=100000;
            while(x<=n){
                commas++;
                x++;
            }
        }
        return commas;
    }
}