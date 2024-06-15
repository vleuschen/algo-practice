package com.akm.algo.sort;

public class QuickSort {

    public static int[] quickSort(int[] nums, int low, int high) {
        if (nums.length < 0 || low < 0 || high > nums.length || low > high) {
            return null;
        }

        int zonedInedx = partition(nums, low, high);
        if (zonedInedx > low) {
            quickSort(nums, low, zonedInedx - 1);
        }
        if (zonedInedx < high) {
            quickSort(nums, zonedInedx + 1, high);
        }

        return nums;
    }

    public static int partition(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }

        int pivot = low;
        int zonedIndex = low-1;
        swap(nums, pivot, high);
        for (int i = low; i <= high; i++) {
            if (nums[i] <= nums[high]) {
                zonedIndex++;
                if (i > zonedIndex) {
                    swap(nums,i,zonedIndex);
                }
            }
        }

        return zonedIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 6, 1, 3};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
