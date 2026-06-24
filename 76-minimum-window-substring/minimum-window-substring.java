class Solution {
    public String minWindow(String s, String t) {

        // If t is longer than s, impossible to find a valid window
        if (s.length() < t.length()) {
            return "";
        }

        // Stores how many of each character we still need
        int[] need = new int[256];

        // Build frequency map for t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;

        // Number of characters from t successfully matched
        int matched = 0;

        // Stores best answer found so far
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Expand the window using right pointer
        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            /*
             * If need[rightChar] > 0,
             * this character was still required.
             *
             * Example:
             * need['A'] = 1
             * we found an A
             * => matched++
             */
            if (need[rightChar] > 0) {
                matched++;
            }

            /*
             * Include current character in the window.
             *
             * Example:
             * need['A'] = 1
             * after taking A -> need['A'] = 0
             *
             * Extra A's will make it negative.
             */
            need[rightChar]--;

            /*
             * When matched == t.length(),
             * current window contains all required characters.
             */
            while (matched == t.length()) {

                // Update minimum window if current one is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                /*
                 * Remove leftChar from the window.
                 *
                 * Since it's leaving the window,
                 * restore its requirement.
                 */
                need[leftChar]++;

                /*
                 * If need[leftChar] becomes positive,
                 * we just removed a required character.
                 *
                 * Example:
                 * need['A'] was 0
                 * after increment -> 1
                 *
                 * Window is now missing one A.
                 */
                if (need[leftChar] > 0) {
                    matched--;
                }

                // Shrink window
                left++;
            }
        }

        // No valid window found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}