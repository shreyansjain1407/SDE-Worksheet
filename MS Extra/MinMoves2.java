class MinMoves2 {
    
    public int minMoves2(int[] nums) {
        long minMoves = Integer.MAX_VALUE;
        for(int num: nums){
            long sum = 0;
            for(int n : nums){
                sum += Math.abs(num - n);
            }
            minMoves = Math.min(minMoves, sum);
        }

        return (int) minMoves;
    }
}