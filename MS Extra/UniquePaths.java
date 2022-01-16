class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
//            |   |   |   |
//            V   V   V   V
//        ->   ->  ->  ->
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                arr[j] = arr[j-1] + arr[j];
            }
        }
        return arr[n-1];
    }
}