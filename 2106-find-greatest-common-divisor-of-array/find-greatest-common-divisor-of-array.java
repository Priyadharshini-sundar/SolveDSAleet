class Solution {
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
            else if(min > nums[i]){
                min = nums[i];
            }
        }
        return gcd(min, max);
    }
}