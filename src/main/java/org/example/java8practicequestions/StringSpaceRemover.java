package org.example.java8practicequestions;

public class StringSpaceRemover {

    public static void main(String[] args) {
        String text = "  Hello  World  with   spaces   ";
        System.out.println("Original: '" + text + "'");

        // Method 1: Using replace() to remove all spaces
        String noSpaces1 = text.replace(" ", "");
        System.out.println("Using replace(): '" + noSpaces1 + "'");

        // Method 2: Using replaceAll() with regex to remove all whitespace characters
        String noSpaces2 = text.replaceAll("\\s+", "");
        System.out.println("Using replaceAll(\\s+): '" + noSpaces2 + "'");

        // Method 3: Using replaceAll() to remove only spaces
        String noSpaces3 = text.replaceAll(" ", "");
        System.out.println("Using replaceAll(' '): '" + noSpaces3 + "'");

        // Method 4: Using StringBuilder for manual removal
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        String noSpaces4 = sb.toString();
        System.out.println("Using StringBuilder: '" + noSpaces4 + "'");
    }
}

