class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                // place 0 in the 'low' region
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in the middle region already
                mid++;
            } else {
                // nums[mid] == 2 → place in the 'high' region
                swap(nums, mid, high);
                high--;
                // note: mid not incremented here
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
