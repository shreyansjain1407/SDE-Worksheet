class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int curSum = 1;
        int curMax = 0;
        int left = 1, right = 1;
        while(right <= n){
//            System.out.println(left + " " + right + " " + curSum);
            if(curSum == n){
                curMax++;
//                for(int i = left; i <= right; i++){
//                    System.out.print(i + " ");
//                }
//                System.out.println(" ");
                right++;
                curSum += right;
            }else if(curSum < n){
                right++;
                curSum += right;
            }else{
                curSum -= left;
                left++;
            }
        }

        return curMax;
    }

    public static void main(String[] args) {
        for(int i = 0; i <= 16; i++)
            System.out.println(i + " " + new Solution().consecutiveNumbersSum(i));
    }
}