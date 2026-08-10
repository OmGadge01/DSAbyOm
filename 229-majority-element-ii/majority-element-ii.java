class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
      for(int num : nums){
        if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
        } else {
        map.put(num, 1);
       }
        if(map.get(num) > (int)(n/3)){
            if(!list.contains(num)){
                list.add(num);
            }
        }

      } 
      return list; 

    }
}