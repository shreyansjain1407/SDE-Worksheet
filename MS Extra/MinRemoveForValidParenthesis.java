class MinRemoveForValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        int left = 0, right = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < sb.length()){
//            System.out.println(sb.toString());
            if(sb.charAt(i) == '('){
                stack.push(i);
            }else if (sb.charAt(i) == ')'){
                if(stack.isEmpty()){
                    sb.deleteCharAt(i);
                    continue;
                }else{
                    stack.pop();
                }
            }
            i++;
        }

        while (!stack.isEmpty()){
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new Solution().minRemoveToMakeValid("abc(d)(("));
    }
}