class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int[] append = new int[2];
        append[0] = lower;
        append[1] = lower;
        List<String> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != append[0]){
                append[1] = nums[i]-1;
                String x = append[0] == append[1] ? String.valueOf(append[0]) : append[0] + "->" + append[1];
                output.add(x);
                append[0] = nums[i] + 1;
            }else{
                append[0]++;
            }
        }
        if(append[0] <= upper){
            append[1] = upper;
            String x = append[0] == append[1] ? String.valueOf(append[0]) : append[0] + "->" + append[1];
            output.add(x);
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.print("[");
        for(int i = 0; i < 100; i+=2)
            System.out.print(i + " ,");
        System.out.println("]");
    }
}