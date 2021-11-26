class MaxLength{
    int maxLen(int A[], int n){
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, sum = A[0];
        if(sum != 0)
            map.put(sum,0);
        else
            maxLength = 1;
        for (int i = 1; i < A.length; i++){
            sum += A[i];
            if (sum == 0) {
                maxLength = i + 1;
            }else if (map.containsKey(sum)){
                maxLength = Math.max(maxLength, i - map.get(sum));
            }else {
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}