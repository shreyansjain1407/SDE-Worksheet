class LongestSubstrWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int i = 0, j = 0, max = 0, count = 0;
        do {
            HashMap<Character, Integer> map = new HashMap<>();
            count = 0;
            j = i;
            while (j < s.length()) {
                if (map.containsKey(s.charAt(j))) {
                    max = Math.max(count, max);
                    i = map.get(s.charAt(j))+1;
                    break;
                } else {
                    map.put(s.charAt(j), j);
                    count++;
                }
                j++;
            }
        } while (j != s.length());
        
        return Math.max(count, max);
    }
}