class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int n = nums.length;
       int r =0;
       int l =0;
       double sum = 0;
       double maxsum =Integer.MIN_VALUE;
       while(r<n){
        sum = sum + nums[r];
        r++;
        if(r-l+1 == k+1){
            maxsum = Math.max(sum , maxsum);
            sum =sum - nums[l];
            l++;
        }
       }
       return k == 1 ? maxsum : maxsum/k;
    }
}