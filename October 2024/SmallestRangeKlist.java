class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
       
        int n = nums.size();
        int[] index = new int[n];
        int[] range = new int[] { 0, Integer.MAX_VALUE };

        while (true) {
            int minElement = Integer.MAX_VALUE;
            int maxElement = Integer.MIN_VALUE;
            int minListIndex = 0;
            for (int i = 0; i < n; i++) {
                int currentElement = nums.get(i).get(index[i]);
             
                if (currentElement < minElement) {
                    minElement = currentElement;
                    minListIndex = i;
                }
                maxElement = Math.max(maxElement, currentElement);
            }
            if (maxElement - minElement < range[1] - range[0]) {
                range[0] = minElement;
                range[1] = maxElement;
            }
            int nextIndex = ++index[minListIndex];
            if (nextIndex == nums.get(minListIndex).size()) {
                break;
            }
        }
        return range;
    } 
    }
