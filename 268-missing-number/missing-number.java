class Solution {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        
        int totalSum = (nums.length*(nums.length + 1)) / 2;

        for(int num : nums){
            actualSum += num;
        }

        int result = totalSum - actualSum;
        return result;
    }
}