class DecodeString {
    public String decodeString(String s) {
        int start = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int temp = s.charAt(i);
            if(Character.isDigit(temp)){
                int[] num = getInt(i,s);
                start = num[0];
                Stack<Character> stack = new Stack<>();
                stack.push(s.charAt(start));
                start++;
                while(!stack.isEmpty() && start<s.length()){
                    if(s.charAt(start) == '['){
                        stack.push('[');
                    }else if(s.charAt(start) == ']'){
                        stack.pop();
                    }
                    start++;
                }
                sb.append(helper(num[1], s, num[0], start-1));
                i = start;
                continue;
            }else if(Character.isAlphabetic(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    private String helper(int times, String s, int st, int end) {
        StringBuilder sb = new StringBuilder();
        int i = st;
        int start = 0;
        while(i < end){
            int temp = s.charAt(i);
            if(Character.isDigit(temp)){
                int[] num = getInt(i,s);
                start = num[0];
                Stack<Character> stack = new Stack<>();
                stack.push(s.charAt(start));
                start++;
                while(!stack.isEmpty() && start<end){
                    if(s.charAt(start) == '['){
                        stack.push('[');
                    }else if(s.charAt(start) == ']'){
                        stack.pop();
                    }
                    start++;
                }
                sb.append(helper(num[1], s, num[0], start-1));
                i = start;
                continue;
            }else if(Character.isAlphabetic(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString().repeat(times);
    }

    private int[] getInt(int i, String s) {
        int num = 0, j = i;
        while(Character.isDigit(s.charAt(j))){
            num = num*10 + (s.charAt(j) - '0');
            j++;
        }
        return new int[]{j, num};
    }


    public static void main(String[] args) {
//        System.out.println(new Scratch().decodeString("3[a]2[bc]"));;
//        System.out.println(new Scratch().decodeString("3[a2[c]]"));;
        System.out.println(new Scratch().decodeString("2[abc]3[cd]ef"));;
    }
}