class MinCharToPalindrome {
    public int solve(String A) {
        if(A.length() == 1)return 0;
        int palindromeLength = 0;
        for(int i = 0; i < 2*A.length()-2; i++){
            int temp = closestPalindrome(A, i);
            if(palindromeLength < temp){
                palindromeLength = temp;
            }
        }

        if(palindromeLength == A.length()){
            return 0;
        }
        // System.out.println(A.length() + " " + palindromeLength);
        return A.length() - palindromeLength;
    }

    public int closestPalindrome(String s, int i){
        int len = 0, l = 0, r = 0;
        if(i % 2 == 0){
            l = i/2 - 1; r = i/2 + 1; len = 1;
            while(l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))){
                len += 2;
                l--;r++;
            }
        }else{
            l = i/2 - 1; r = i/2; len = 0;
            while(l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))){
                len += 2;
                l--;r++;
            }
        }

        return (l == -1)?len:0;
    }
}