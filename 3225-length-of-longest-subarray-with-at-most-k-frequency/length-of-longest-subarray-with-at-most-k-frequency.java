class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
       int n  = nums.length;
       int l =0;
       int r =0;
       int maxlen = 0;

       HashMap<Integer , Integer> map = new HashMap<>();

        if(k > n) return n;
       while(r<n){
        if(map.containsKey(nums[r])){
            map.put(nums[r] , map.get(nums[r]) + 1);
        }
        else{
            map.put(nums[r] , 1);
        }
            while(map.get(nums[r]) > k){
                map.put(nums[l] , map.get(nums[l]) - 1);
                l++;
            }
         
        maxlen = Math.max(maxlen , r - l + 1);
        r++;
       }
       return maxlen;
    }
}