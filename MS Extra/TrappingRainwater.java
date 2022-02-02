class TrappingRainwater {
    public int trap(int[] height) {
        int water = 0;
        int left = 0, right = height.length-1;
        int leftMax = height[left], rightMax = height[right];
        while(left < right){
            while(left < right && height[left] <= height[right]){
                leftMax = Math.max(leftMax, height[left]);
                water += Math.max(height[left], leftMax) - height[left];
//                System.out.println(left + " " + height[left] + " " + leftMax + " " + height[left] + " " + water);
                left++;
            }
//            leftMax = Math.max(leftMax, height[left]);
            while(right > left && height[right] <= height[left]){
                rightMax = Math.max(rightMax, height[right]);
                water += Math.max(height[right], rightMax) - height[right];
//                System.out.println(right + " " + height[right] + " " + rightMax + " " + height[right] + " " + water);
                right--;
            }
            rightMax = Math.max(rightMax, height[right]);
        }
        return water;
    }

    public static void main(String[] args) {
//        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] arr = {4,2,0,3,2,5};
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(new Solution().trap(arr));
    }
}