import java.util.*;
class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0) return 0;
        int num = Integer.parseInt(String.valueOf(n).replace("0", ""));
        int original = num;
        int sum = 0;
        while(num > 0){

            sum +=  num % 10;
            num /= 10;
        }
        long result = (long)original * sum;
        return result;
    }
}