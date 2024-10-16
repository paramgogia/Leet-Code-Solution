class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
    int n = nums.size();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int m = Integer.MAX_VALUE;
            boolean f = false;
            
            for (int b = 0; b <= 30; b++) {
                if (((x >> b) & 1) == 1) {
                    int c = x & ~(1 << b);
                    
                    if (c < 0) continue;
                    
                  
                    if ((c | (c + 1)) == x) {
                        if (c < m) {
                            m = c;
                            f = true;
                        }
                    }
                }
            }
            
            if (f) {
                a[i] = m;
            } else {
                a[i] = -1;
            }
        }
        
        return a;
    }
}
