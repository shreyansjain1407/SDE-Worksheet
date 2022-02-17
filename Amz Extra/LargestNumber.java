class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            arr.add(String.valueOf(nums[i]));
        }
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if(arr.get(0).equals("0"))return "0";
        StringBuilder sb = new StringBuilder();
        for(String str : arr)
            sb.append(str);
        return sb.toString();
    }
}