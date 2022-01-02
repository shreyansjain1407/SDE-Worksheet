class LongestPalindrome {
    public String longestPalindrome(String s) {
        int length = 2*s.length() -1;
        int maxLength = 0, index = 0;
        String out = s.substring(0,1);
        for(int i = 0; i<length; i++){
            int pLength = findPalimdrome(s, i);
            if(pLength > maxLength){
                maxLength = pLength;
                index = i;
            }
            
        }
        int temp = maxLength/2;
        if(maxLength == 0)return out;
        if(index % 2 == 0){
            out = s.substring((index/2 - temp), (index/2 + temp));
        }else{
            out = s.substring((index/2 - temp), (index/2 + temp + 1));
        }
        return out;
    }
    
    public int findPalimdrome(String s, int i){
        int x = i/2;
        int length = 0, l = 0 ,r = 0;
        if(i%2 == 1){
            length = 1;
            l = x-1;
            r = x+1;
        }else{
            length = 0;
            l = x-1;
            r = x;
        }
        
        while(l>=0 && r<=s.length()-1){
            if(s.charAt(l) == s.charAt(r)){
                length+=2;
            }else{break;}
            l--;r++;
        }
        return length;
    }
}