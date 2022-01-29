class MinAddMakeParenthesisValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    count++;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.size() + count;
    }

    //Approach 2
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                if(left == 0){
                    right++;
                }else{
                    left--;
                }
            }
        }
        return left + right;
    }
}