package org.example.java8practicequestions;

public class PalindromeChecker {

    // Check if an integer is a palindrome
    public static boolean isIntegerPalindrome(int num) {
        int original = num;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }

        return original == reversed;
    }

    // Check if a string is a palindrome (ignores case and spaces)
    public static boolean isStringPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase(); // ignore spaces and case
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Integer Palindrome Check
        int num1 = 121;
        int num2 = 12321;

        System.out.println("Integer 1: " + num1 + " -> Palindrome? " + isIntegerPalindrome(num1));
        System.out.println("Integer 2: " + num2 + " -> Palindrome? " + isIntegerPalindrome(num2));

        // String Palindrome Check
        String str1 = "madam";
        String str2 = "Race car";

        System.out.println("String 1: \"" + str1 + "\" -> Palindrome? " + isStringPalindrome(str1));
        System.out.println("String 2: \"" + str2 + "\" -> Palindrome? " + isStringPalindrome(str2));
    }
}
