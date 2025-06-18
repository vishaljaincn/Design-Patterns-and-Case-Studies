package org.example.Strings;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        int maxLength = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            while (hm.get(s.charAt(i)) > 1) {
                hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                if (hm.get(s.charAt(j)) == 0) {
                    hm.remove(s.charAt(j));
                }
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}