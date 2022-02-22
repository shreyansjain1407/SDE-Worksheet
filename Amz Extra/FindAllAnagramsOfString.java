class FindAllAnagramsOfString {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length())return new ArrayList<>();
        // int sLen = s.length();
        // int pLen = p.length();
        int[] pArr = new int[26];
        for(char c : p.toCharArray())
            pArr[c - 'a']++;
        int[] sArr = new int[26];
        int i = 0;
        List<Integer> out = new ArrayList<>();
        while(i < s.length()){
            if(i >= p.length()){
                sArr[s.charAt(i-p.length()) - 'a']--;
            }
            sArr[s.charAt(i) - 'a']++;
            if(Arrays.equals(pArr, sArr)){
                out.add(i - p.length() + 1);
            }
            i++;
        }
        return out;
    }
}