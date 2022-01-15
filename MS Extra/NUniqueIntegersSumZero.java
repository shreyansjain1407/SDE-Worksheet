class NUniqueIntegersSumZero {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int len = arr.length;
        for(int i = 1; i <= n/2; i++){
            arr[i-1] = i;
            arr[len-i] = -i;
        }
        if(n%2 != 0){
            arr[n/2] = 0;
        }
        return arr;
    }
}