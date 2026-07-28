class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();
        int idx =0;
        if (m == 0) return true;
        if (n == 0) return false;
        for(int i = 0;i<n;i++){
            if(s.charAt(idx) == t.charAt(i)){
                idx++;
                if(idx == m) return true;
            }
        }
        return false;
    }
}