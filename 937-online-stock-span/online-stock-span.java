class StockSpanner {

    List<Integer> lst;

    public StockSpanner() {
        lst = new ArrayList<>();
    }

    public int next(int price) {
        lst.add(price);
        int n = lst.size();
        int count = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (lst.get(i) <= price) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}