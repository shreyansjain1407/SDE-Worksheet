class RandomPickWithWeight {
    int[] aux;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        aux = new int[w.length];
        aux[0] = w[0];
        for(int i = 1; i < w.length; i++){
            aux[i] = aux[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int cur = random.nextInt(aux[aux.length-1])+1;
        // System.out.println("Random: " + cur);
        // System.out.println(Arrays.toString(aux));
        int left = 0, right = aux.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(aux[mid] == cur){
                // System.out.println("EXE: " + mid);
                return mid;
            }else if(aux[mid] < cur){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        // System.out.println(left + " " + right);
        return left;
    }

    public static void main(String[] args) {

        Solution s = new Solution(new int[]{3,14,1,7});
        int[] arr = new int[4];
        for(int i = 0; i < 25; i++)
            arr[(s.pickIndex())]++;
        System.out.println(Arrays.toString(arr));
    }
}