class WaterTrap {
    public int trap(int[] height) {
        int total = 0, left = 0, right = height.length -1;
        int leftBase = 0, rightBase = 0;
        while(left < right){
            while (height[left] <= rightBase && height[left] <= leftBase && left<right){
                total += leftBase - height[left];
                left++;
            }
            if(height[left] > leftBase){
                leftBase = height[left];
            }
            while (height[right] <= leftBase && height[right] <= rightBase && right>left){
                total += rightBase - height[right];
                right--;
            }
            if (height[right] > rightBase){
                rightBase = height[right];
            }
        }
        return total;
    }
}

//Attempt 1 50% Test Cases Cleared
// class WaterTrap {
//     public int trap(int[] height) {
//         if(height.length < 3)return 0;
//         int maxCount = 0;
//         int abc = (height[0] == 0)?findMax(height,0)[1]:0;
//         while(abc < height.length){
//             int count = 0;
//             int i = abc;
//             while(i < height.length){
//     //            System.out.println("Sequence: " + i);
//                 int[] max = findMax(height, i);
//     //            System.out.println(Arrays.toString(max));
//                 if(max[0] == max[1]){
//                     i = max[1];
//                     continue;
//                 }
//                 //Checking if a maxima has been returned
//                 if(max[1] == -1 || max[1] >= height.length || height[max[0]] >= height[max[1]])
//                     break;
//                 int maxHeight = Math.min(height[i],height[max[1]]);
//     //            System.out.println("MaxHeight: " + maxHeight);
//                 for (int x = i+1; x < max[1]; x++){
//                     count += (maxHeight - height[x]);
//                 }
//     //            System.out.println("Current Count: " + count);
//                 i = max[1];
//             }
//             System.out.println(count);
//             maxCount = Math.max(count, maxCount);
//             abc++;
//         }

//         return maxCount;
//     }

//     public int[] findMax(int[] arr, int i){

//         int cur = arr[i];
//         int end = i;
//         while(end < arr.length -1 && arr[end] >= arr[end+1]){
//             end++;
//         }
//         int floor = end;
// //        System.out.println("Floor" + floor);
//         while(end < arr.length -1 && arr[end] <= arr[end+1]){
//             end++;
//         }
//         int nextPeak = end;
// //        System.out.println("NextPeak: " + nextPeak);
//         if(nextPeak == i){
//             return new int[]{nextPeak,-1};
//         }if (floor == i){
//             return new int[]{nextPeak,nextPeak};
//         }
//         if (arr[nextPeak] >= arr[i]) {
// //            System.out.println(i);
// //            System.out.println("Return Point");
//             return new int[]{floor, nextPeak};
//         }

// //        System.out.println("Statement after first return");
//         int x, ultMax;
//         if(i+1 < arr.length) {
//             x = i + 1;
//             ultMax = arr[i + 1];
//         }else{
//             return new int[]{floor, nextPeak};
//         }
// //        System.out.println("Value of X: " + x);
//         while(x < arr.length){
//             ultMax = Math.max(ultMax,arr[x]);
// //            System.out.println("UltMax: " + ultMax + " Arr[x]: " + arr[x]);
//             if (ultMax > cur)
//                 break;
//             x++;
//         }
//         while(x < arr.length - 1 && arr[x] <= arr[x+1]) {
// //            System.out.println(arr[x] + " " + arr[x+1]);
//             x++;
//         }
//         if (ultMax > arr[nextPeak])
//             return new int[]{floor, x};
//         else{
//             return new int[]{floor, nextPeak};
//         }
//     }
// }