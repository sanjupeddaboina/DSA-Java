/* Online stock span: Given an array of integers arr, there is a sliding window of size k which is moving from the 
very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves 
right by one position. Return the max sliding window..
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
