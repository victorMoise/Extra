public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = removeOther(s);
        String reversed = new StringBuilder(s).reverse().toString();

        return s.equals(reversed);
    }

    public static String removeOther(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        return s;
    }
}
