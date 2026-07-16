import java.util.Arrays;
class Solution {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b); 
    }
    
    public long gcdSum(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n];

        int max = nums[0];

        for (int i = 0; i < n; i++) {

            if (nums[i] > max) {
                max = nums[i];
            }

            arr[i] = gcd(nums[i], max);
        }

        Arrays.sort(arr);

        long sum = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            sum += gcd(arr[left], arr[right]);
            left++;
            right--;
        }

        return sum;
    }
}