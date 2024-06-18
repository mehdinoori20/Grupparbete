package se.mehdi.securewebapp.util;

public class MaskingUtils {
    public static String anonymize(String email) {
        String[] parts = email.split("@");
        if (parts.length > 1) {
            String name = parts[0];
            if (name.length() > 1) {
                return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + parts[1];
            }
            return "*****@" + parts[1];
        }
        return "*****";
    }
}
