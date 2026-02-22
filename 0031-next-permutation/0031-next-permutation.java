class Solution {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // 1. find pivot
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. find next greater and swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. reverse suffix
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverse(int[] a, int l, int r) {
        while (l < r) {
            swap(a, l++, r--);
        }
    }
}
