/* Avoid Flood in City:
Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. 
If it rains over a lake that is full of water, there will be a flood. Your goal is to avoid floods in any lake.

Given an integer array rains where:
rains[i] > 0 means there will be rains over the rains[i] lake.
rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.

Return an array ans where:
ans.length == rains.length
ans[i] == -1 if rains[i] > 0.
ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.

If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.
*/

public class Main{
    static int[] avoidFlood(int[] rains){
		//Write your code here
		Map<Integer,Integer> lakeRainDay = new HashMap<>();
		TreeSet<Integer> noRainDay = new TreeSet<>();
		int[] ans = new int[rains.length];
      
		for(int i=0; i<rains.length; i++){
			int rain = rains[i];
      
			if(rain == 0){
				noRainDay.add(i);
			}else if(!lakeRainDay.containsKey(rain)){
				lakeRainDay.put(rain,i);
				ans[i] = -1;
			}else{
				int lake = lakeRainDay.get(rain);
				Integer dryDay = noRainDay.higher(lake);
        
				if(dryDay == null){
					return new int[0];
				}
        
				noRainDay.remove(dryDay);
				ans[dryDay] = rain;
				lakeRainDay.put(rain,i);
				ans[i] = -1;
			}
		}
      
		for(int j=0; j<ans.length; j++){
			if(ans[j] == 0){
				ans[j] = 1;
			}
		}
      
		return ans;
    }
}
