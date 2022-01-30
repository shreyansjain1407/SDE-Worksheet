class MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for(int i = 0; i < digits.length-1; i++){
            if(digits[i] < digits[i+1]){
                int j = i+1;
                int maxId = j;
                while(j < digits.length){
                    if(digits[j] - '0' >= digits[maxId] - '0'){
                        maxId = j;
                    }
                    j++;
                }
                for(int k = 0; k <= i; k++){
                    if(digits[k] - '0' < digits[maxId] - '0'){
                        char temp = digits[maxId];
                        digits[maxId] = digits[k];
                        digits[k] = temp;
                        return Integer.parseInt(new String(digits));
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(2736));
    }
}