class TrappingRainwater {

    public int trap(int[] height) {
        int total = 0, left = 0, right = height.length -1;
        int leftBase = 0, rightBase = 0;
        while(left < right){
            while (height[left] <= rightBase && height[left] <= leftBase && left<right){
                total += leftBase - height[left];
                left++;
//                System.out.println("RIghtBase: " + rightBase);
                System.out.println("Incremented at left: " + total);
            }
            if(height[left] > leftBase){
                leftBase = height[left];
            }
            while (height[right] <= leftBase && height[right] <= rightBase && right>left){
                total += rightBase - height[right];
                right--;
                System.out.println("Incremented at Right: " + total);

            }
            if (height[right] > rightBase){
                rightBase = height[right];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,2};
//        Manually Tried TestCases
//        [0,1,0,2,1,0,1,3,2,1,2,1]
//        [4,2,0,3,2,5]
//        [6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3]
//        [5,2,1,2,1,5]
//        [5,4,1,2]
//        [0,0,0,0]
//        [1,1,1,1,1,1,1,2,1,1,1,1,1,1]
//        [1,1,14,2,10,9,4,8,0]
        System.out.println(new Scratch().trap(arr));
    }
}