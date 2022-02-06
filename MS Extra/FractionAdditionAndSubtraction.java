class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        int[] arr = new int[11];
        int numerator = 0, denominator = 0;
        int i = 0;
        int commonDenominator = 1;
        while(i < expression.length()){
            char c = expression.charAt(i);
            if(c == '-'){
                i++;
                numerator = getNumber(expression, i);
                i = (numerator == 10) ? i+3 : i+2;
                denominator = getNumber(expression, i);
                i = (denominator == 10) ? i+2 : i+1;
                arr[denominator] -= numerator;
            }else if(c == '+'){
                i++;
                numerator = getNumber(expression, i);
                i = (numerator == 10) ? i+3 : i+2;
                denominator = getNumber(expression, i);
                i = (denominator == 10) ? i+2 : i+1;
                arr[denominator] += numerator;
            }
            if(commonDenominator % denominator != 0){
                commonDenominator *= denominator;
            }
        }
//        System.out.println(Arrays.toString(arr));
//        int commonDenominator = 0;
        int sum = 0;
        for(int x = 1; x < arr.length; x++){
            sum += arr[x]*commonDenominator / x;
        }
        int cmDevisor = gcd(Math.abs(sum), commonDenominator);
        sum /= cmDevisor;
        commonDenominator /= cmDevisor;


        return "" + sum + "/" + (commonDenominator == 0? 1 : commonDenominator);
    }

    private int gcd(int abs, int commonDenominator) {
        while(commonDenominator != 0){
            int temp = commonDenominator;
            commonDenominator = abs % commonDenominator;
            abs = temp;
        }
        return abs;
    }

    private int getNumber(String expression, int i) {
//        System.out.println("GET NUM: " + i);
        int x = 0;
        while(i < expression.length() && Character.isDigit(expression.charAt(i))){
            x *= 10;
            x += expression.charAt(i) - '0';
            i++;
        }
//        System.out.println("X: " + x);
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionAddition("-1/10+1/2+1/3"));
        System.out.println(new Solution().fractionAddition("-1/2+1/2"));
        System.out.println(new Solution().fractionAddition("1/3-1/2"));
    }
}