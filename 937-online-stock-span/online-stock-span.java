class StockSpanner {

    List<Integer> prices;
    Stack<Integer> st;

    public StockSpanner() {
        prices = new ArrayList<>();
        st = new Stack<>();
    }

    public int next(int price) {

        prices.add(price);
        int idx = prices.size() - 1;

        while (!st.isEmpty() && prices.get(st.peek()) <= price) {
            st.pop();
        }

        int span = st.isEmpty() ? idx + 1 : idx - st.peek();

        st.push(idx);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */