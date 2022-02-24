class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        String exp = expression.replaceAll("\\-","+-");
        // System.out.println(exp);
        String[] fraction = exp.split("\\+");
        // System.out.println(Arrays.toString(fraction));
        int prev_num = 0, prev_din = 1;
        for(String frac : fraction){
            if(frac.length() == 0)continue;
            boolean neg = frac.charAt(0) == '-';
            if(neg) frac = frac.substring(1);
            String[] numAndDin = frac.split("/");
            // System.out.println(Arrays.toString(numAndDin));
            int cur_num = Integer.parseInt(numAndDin[0]);
            int cur_din = Integer.parseInt(numAndDin[1]);
            // System.out.println(Arrays.toString(numAndDin));
            int g = Math.abs(gcd(prev_din, cur_din));
            if(neg){
                prev_num = prev_num * cur_din / g - cur_num * prev_din / g;
            }else{
                prev_num = prev_num * cur_din / g + cur_num * prev_din / g;
            }
            prev_din = prev_din * cur_din / g;
            g = Math.abs(gcd(prev_din, prev_num));
            prev_num /= g;
            prev_din /= g;
            
        }
        
        return prev_num + "/" + prev_din;
    }

    private int gcd(int a, int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}