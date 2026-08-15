class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxsum = 0;
        int rsum = 0;
        int lsum = 0;
        int n = cardPoints.length;
        for(int i =0 ;i<=k-1;i++){
            lsum += cardPoints[i];
            maxsum = lsum;
        }
        int lidx = n-1;
        for(int i = k-1;i>=0;i--){
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[lidx];
            lidx--;
            maxsum = Math.max(maxsum , lsum + rsum);
        }
        
         return maxsum;
    }
   
}