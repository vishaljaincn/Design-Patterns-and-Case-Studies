package org.example.java8practicequestions;

public class IPv4Validator {

    public static boolean isValidIPv4(String ip) {
        // Step 1: Null or empty check
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        // Step 2: Count the dots (must be exactly 3)
        int dotCount = 0;
        for (char c : ip.toCharArray()) {
            if (c == '.') {
                dotCount++;
            }
        }
        if (dotCount != 3) {
            return false;
        }

        // Step 3: Split into parts
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        // Step 4: Validate each octet
        for (String part : parts) {
            // Empty or too long
            if (part.isEmpty() || part.length() > 3) {
                return false;
            }

            // No leading zeros allowed (except "0" itself)
            if (part.length() > 1 && part.startsWith("0")) {
                return false;
            }

            // Must be all digits
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            try {
                int value = Integer.parseInt(part);
                if (value < 0 || value > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        // If all checks pass
        return true;
    }

    // Test driver
    public static void main(String[] args) {
        String[] testIPs = {
                "192.168.1.1",
                "255.255.255.255",
                "0.0.0.0",
                "192.168.01.1",  // invalid (leading zero)
                "256.100.100.100", // invalid (>255)
                "192.168.1", // invalid (not 4 octets)
                "192.168.1.1.1", // invalid (too many octets)
                "abc.def.gha.bcd" // invalid (not numbers)
        };

        for (String ip : testIPs) {
            System.out.println(ip + " -> " + isValidIPv4(ip));
        }
    }
}
