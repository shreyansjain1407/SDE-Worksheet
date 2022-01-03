class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int prefixLen = 0;
        int k = 0;
        int minLen = Integer.MAX_VALUE;
        for(String str : strs){
            minLen = Math.min(minLen, str.length());
        }
        if(minLen == 0)
            return "";
        boolean isSame = true;
        while(k < minLen && isSame) {
            char c = strs[0].charAt(k);
            for (String str : strs) {
                if (!(str.charAt(k) == c)) {
                    isSame = false;
                    break;
                }
            }
            if(isSame)
                prefixLen++;
            k++;
        }

        return strs[0].substring(0, prefixLen);
    }
}