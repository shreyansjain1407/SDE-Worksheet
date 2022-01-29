class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        return helper(0, s.length()-1, s, false);
    }

    private boolean helper(int left, int right, String s, boolean removed) {
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;right--;
                continue;
            }
            if(removed)return false;
            return helper(left+1, right, s, true) || helper(left, right-1, s, true);
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().validPalindrome("deeee"));
        System.out.println(new Solution().validPalindrome("ebcbbececabbacecbbcbe"));
    }
}