class Solution {
    public int reverse(int x) {
        int reverseInt = 0;
        while (x != 0) {
            int modValue = x % 10;
            x = x / 10;
            if (reverseInt > Integer.MAX_VALUE / 10 || 
               (reverseInt == Integer.MAX_VALUE / 10 && modValue > 7)) {
                return 0;
            }
            if (reverseInt < Integer.MIN_VALUE / 10 || 
               (reverseInt == Integer.MIN_VALUE / 10 && modValue < -8)) {
                return 0;
            }
            reverseInt = reverseInt * 10 + modValue;
        }
        return reverseInt;
    }
}