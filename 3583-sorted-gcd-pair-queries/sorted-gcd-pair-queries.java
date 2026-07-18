// import java.util.Arrays;
// class Solution {
//     public int gcd(int a, int b){
//         if(b == 0){
//             return a;
//         }
//         return gcd(b, a % b);
//     }
//     public int[] gcdValues(int[] nums, long[] queries) {
//         Arrays.sort(nums);

//         int n = nums.length;
//         int totalPairs = n * (n - 1) / 2;
//         int[] arr = new int[totalPairs];

//         int k = 0;

//         for(int i = 0; i < nums.length; i++){
//             for(int j = i + 1; j < nums.length; j++){
//                     arr[k++] = gcd(nums[i], nums[j]);
//             }
//         }

//         Arrays.sort(arr);

//         int[] res = new int[queries.length];

//         for(int i = 0; i < queries.length; i++){
//             res[i] = arr[(int)queries[i]];
//         }

//         return res;
//     }
// }

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] frequency = new int[max + 1];

        for (int num : nums) {
            frequency[num]++;
        }

        int[] divisibleCount = new int[max + 1];

        // Count numbers divisible by each g
        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                divisibleCount[g] += frequency[multiple];
            }
        }

        long[] gcdPairs = new long[max + 1];

        // Find pairs with GCD exactly g
        for (int g = max; g >= 1; g--) {

            long count = divisibleCount[g];

            gcdPairs[g] = count * (count - 1) / 2;

            for (int multiple = g + g;
                 multiple <= max;
                 multiple += g) {

                gcdPairs[g] -= gcdPairs[multiple];
            }
        }

        // Prefix sum
        long[] prefix = new long[max + 1];

        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + gcdPairs[g];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long query = queries[i];

            int left = 1;
            int right = max;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] > query) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = left;
        }

        return answer;
    }
}