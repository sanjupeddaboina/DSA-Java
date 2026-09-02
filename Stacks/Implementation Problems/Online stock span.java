/* Online stock span: Given an array arr of size n, where each element arr[i] represents the stock price on day i. 
Calculate the span of stock prices for each day.

The span Sᵢ for a specific day i is defined as the maximum number of consecutive previous days (including the current day)
for which the stock price was less than or equal to the price on day i.
*/

class StockSpanner {

    Stack<Integer> st;
    List<Integer> list;
    int idx = -1;
    
    public StockSpanner() {
        this.st = new Stack<>();
        this.list = new ArrayList<>();
        this.idx = -1;
    }
    
    public int next(int price) {
        idx = idx+1;
        while(!st.isEmpty() && list.get(st.peek()) <= price){
            st.pop();
        }
        int count = idx - (st.isEmpty() ? -1 : st.peek());
        list.add(price);
        st.push(idx);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
