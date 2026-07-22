class Solution {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int square = 0;

            while (n > 0) {
                int digit = n % 10;
                square += digit * digit;
                n /= 10;
            }

            n = square;
        }
        if(n == 1){
            return true;
        }
        else{
            return false;
        }
    }
}