class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ones=0;
        int zeros=0;

        for(int i=0;i<students.length;i++){
            if(students[i]==1){
                ones++;
            }
            else zeros++;
        }
        for(int i=0;i<sandwiches.length;i++){
            if(sandwiches[i]==0){
                if(zeros==0){
                    return ones;
                }
                else zeros--;
            }
            else{
                if(ones==0){
                    return zeros;
                }
                else ones--;
            }
        }
        return ones+zeros;
    }
}