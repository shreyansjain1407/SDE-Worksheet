class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, i = 0;
        int count = 0;
        while(i < s.length()){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right)
                count = Math.max(count, left + right);
            else if(right > left){
                left = 0;right = 0;
            }
            i++;
        }
        
        left = 0;right = 0;i = s.length()-1;
        while(i >= 0){
            if(s.charAt(i) == ')'){
                right++;
            }else{
                // System.out.println("EXE");
                left++;
            }
            if(left == right){
                count = Math.max(count, left + right);
                // System.out.println("Count: " + count);
            }else if(left > right){
                left = 0;right = 0;
            }
            i--;
        }
        return count;
    }
}