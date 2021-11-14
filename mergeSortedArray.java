import java.util.*;

class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= n; i--)
            nums1[i] = nums1[i-n];
        int one = n, two = 0, i = 0;
        while(one < nums1.length && two < n){
            if(nums1[one] <= nums2[two]){
                nums1[i] = nums1[one];
                one++;
            }else {
                nums1[i] = nums2[two];
                two++;
            }
            i++;
        }
        while (one < m){
            nums1[i] = nums1[one];
            one++;i++;
        }
        while (two < n){
            nums1[i] = nums2[two];
            two++;i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,0,0,0};
        int[] arr4 = {2,5,6};
        int[][] arr5 = {{1,4},{2,3}};
        (new Scratch()).merge(arr,3,arr4,arr4.length);
        System.out.println(Arrays.toString(arr));
    }
}