/* Rabbits in Forest:
A certain number of rabbits live in a forest. When asking the ith rabbit that how many rabbits are there who have the same color as his, 
he said there are arr[i] such rabbits excluding him. Find out the minimum number of rabbits that can be present is the forest satisfying this condition.
*/

class Solution{
    public int numRabbits(int[] answers) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<answers.length; i++){
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);
        }
        int totalCount = 0;
        for(int rabbit : map.keySet()){
            int rabbitFreq = map.get(rabbit);
            int groupSize = rabbit+1;
            int totalGroups = (rabbitFreq + groupSize-1)/groupSize;
            totalCount += (totalGroups * groupSize);
        }
        return totalCount;
    }
}
