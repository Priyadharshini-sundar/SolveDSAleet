class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] - 1;
        }
        return nums[nums.length - 2] * nums[nums.length - 1];
    }
}