class BasicCalculator2 {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<Long> operands = new Stack<>();
        int i = 0; 
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                long[] num = getInt(s, i);
                operands.push(num[0]);
                i = (int) num[1]-1;
            }else{
                if(c == '+' || c == '-'){
                    long[] cur = getInt(s,i+1);
                    if(c == '-'){
                        operands.push(-cur[0]);
                    }else{
                        operands.push(cur[0]);
                    }
                    i = (int) cur[1] - 1;
                }else{
                    long[] cur = getInt(s, i+1);
                    long operated = operands.pop();
                    if(c == '*'){
                        operated = operated * cur[0];
                    }else{
                        operated = operated / cur[0];
                    }
                    operands.push(operated);
                    i = (int) cur[1]-1;
                }
            }
            i++;
        }
        long res = 0;
        while(!operands.isEmpty()){
            res += operands.pop();
        }
//        System.out.println(operands.peek());
        return (int) res;
    }

    private long[] getInt(String s, int index) {
        int i = index;
        int count = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            count = count * 10 + (s.charAt(i) - '0');
            i++;
        }
        return new long[]{count, i};
    }

    public static void main(String[] args) {
//        String s = "45   *   54    *    21    +   654 - 621";
//        String s = " 3+5 / 2 ";
        String s = "1 - 1 + 2147483647";
//        String s = "1-5-4+10";
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().calculate(s));
        System.out.println(new Solution().calculate("45   *   54    *    21    +   654 - 621"));
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
        System.out.println(new Solution().calculate("1-5-4+10"));
//        System.out.println(new Solution().calculate(s));
    }
}