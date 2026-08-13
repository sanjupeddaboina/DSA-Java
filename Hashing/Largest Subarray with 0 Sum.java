class Solution {
   public int maxLen(int arr[]){
		// Write your code here
		Map<Integer,Integer> map = new HashMap<>();
		int sum = 0;
		int maxLength = 0;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
			if(sum == 0){
				maxLength = i+1;
			}
			if(map.containsKey(sum)){
				int prevIdx = map.get(sum);
				maxLength = Math.max(maxLength,i-prevIdx);
			}else{
				map.put(sum,i);
			}
		}
		return maxLength;
	}
}
