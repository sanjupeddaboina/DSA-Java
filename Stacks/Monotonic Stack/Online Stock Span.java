/* Online Stock span: 
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) 
for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days are [7,2,1,2] and the price of the stock today is 2, 
then the span of today is 3 because starting from today, the price of the stock was less than or equal to 2 for 3 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, 
then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
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
