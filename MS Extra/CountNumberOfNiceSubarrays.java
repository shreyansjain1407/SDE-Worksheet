class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int num : nums){
            if(num % 2 == 1) {
                list.add(count);
                count = 0;
            }else{
                count++;
            }
        }
        list.add(count);
        int output = 0;
        for(int i = 0; i + k < list.size(); i++){
            output += (list.get(i) + 1) * (list.get(i + k) + 1);
        }
        return output;
    }
}