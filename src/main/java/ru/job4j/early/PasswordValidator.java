package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    private static boolean hasDigit(String password) {
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecial(String password) {
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containForbidden(String password) {
        for (String s : FORBIDDEN) {
            if (password.toLowerCase().contains(s)) {
                return true;
            }
        }
        return false;
    }

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSpecial(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (containForbidden(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: " + "qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
