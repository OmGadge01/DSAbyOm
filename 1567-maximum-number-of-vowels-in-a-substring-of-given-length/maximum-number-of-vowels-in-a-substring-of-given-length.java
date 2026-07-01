class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int count = 0;
        int maxcount =0;
        while(r < n){
             if(s.charAt(r) == 'a' || s.charAt(r) == 'e' || s.charAt(r) == 'i' || s.charAt(r) == 'o' || s.charAt(r) == 'u'){
                count++;
             }

            if(r-l+1 > k){
                if(s.charAt(l) == 'a' || s.charAt(l) == 'e' || s.charAt(l) == 'i' || s.charAt(l) == 'o' || s.charAt(l) == 'u'){
                count--;
                }
                l++;
            }
            maxcount = Math.max(count , maxcount);
            r++;
        }
        return maxcount;
    }
}