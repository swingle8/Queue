class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[n-k+1];
        if (n == 0 || k == 0)
            return ans;
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0 ; i < n ; i ++) {
            while (! dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            
            dq.offerLast(i);
            while (! dq.isEmpty() && dq.peekFirst() < i+1-k)
                dq.pollFirst();
            
            if (i+1 >= k) {
                ans[j] = nums[dq.peekFirst()];
                j++;
            }
        }
        return ans;
    }
}