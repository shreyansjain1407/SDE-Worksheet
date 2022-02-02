class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int curK = 1;
        int i = 0, x = 1;
        while (i < arr.length) {
            if(x != arr[i]){
                k--;
                if(k == 0)
                    return x;
                x++;
            }else{
                x++;
                i++;
            }
        }
        return x + k - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1};
//        int[] arr = {2,3,4,7,11};
        System.out.println(new Solution().findKthPositive(arr, 15));
    }
}