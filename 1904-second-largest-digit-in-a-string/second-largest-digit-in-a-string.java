class Solution {
    public int secondHighest(String s) {
        int n = s.length();
        int largest = -1;
        int secondlargest = -1;
       for(int i =0;i<n;i++){
        if(Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
           if(digit > largest){
            secondlargest = largest;
            largest = digit;
           }

           else if(digit < largest && digit > secondlargest){
             secondlargest = digit;
           }

        }
       } 
       return largest == secondlargest ? -1 : secondlargest;
    }
}