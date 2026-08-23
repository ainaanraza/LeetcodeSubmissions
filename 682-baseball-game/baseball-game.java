class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < operations.length; i++) {

            if (operations[i].equals("+")) {
                int y = st.pop();
                int x = st.pop();

                st.push(x);
                st.push(y);
                st.push(x + y);

            } 
            else if (operations[i].equals("D")) {
                st.push(st.peek() * 2);

            } 
            else if (operations[i].equals("C")) {
                st.pop();

            } 
            else {
                st.push(Integer.parseInt(operations[i]));
            }
        }

        int result = 0;

        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }
}