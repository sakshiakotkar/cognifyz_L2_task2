package com.javaintern;
import java.util.Scanner;
public class PasswordStrengthChecker {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Please Enter your password: ");
            String password = sc.nextLine();

            String Passfeedback = checkPasswordStrength(password);
            System.out.println(Passfeedback);

            sc.close();
        }

        private static String checkPasswordStrength(String password) {
            int lengthScore = getLengthScore(password);
            int uppercaseScore = getUppercaseScore(password);
            int lowercaseScore = getLowercaseScore(password);
            int digitScore = getDigitScore(password);
            int specialCharScore = getSpecialCharScore(password);

            int totalScore = lengthScore + uppercaseScore + lowercaseScore + digitScore + specialCharScore;

            // Providing feedback based on the total score
            String feedback;
            if (totalScore >= 15) {
                feedback = "Your password is very strong!";
            } else if (totalScore >= 10) {
                feedback = "Your password is strong.";
            } else if (totalScore >= 5) {
                feedback = "Your password is weak.";
            } else {
                feedback = "Your password is very weak. Consider making it longer and adding more types of characters.";
            }

            return feedback + "\nDetails:\n" +
                    "Length Score: " + lengthScore + "/5\n" +
                    "Uppercase Letters Score: " + uppercaseScore + "/3\n" +
                    "Lowercase Letters Score: " + lowercaseScore + "/3\n" +
                    "Digits Score: " + digitScore + "/3\n" +
                    "Special Characters Score: " + specialCharScore + "/3\n";
        }

        private static int getLengthScore(String password) {
            int length = password.length();
            if (length >= 12) return 5;
            if (length >= 8) return 3;
            if (length >= 4) return 1;
            return 0;
        }

        private static int getUppercaseScore(String password) {
            int count = 0;
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    count++;
                }
            }
            return Math.min(count, 3);  // Cap the score at 3
        }

        private static int getLowercaseScore(String password) {
            int count = 0;
            for (char c : password.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    count++;
                }
            }
            return Math.min(count, 3);  // Cap the score at 3
        }

        private static int getDigitScore(String password) {
            int count = 0;
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    count++;
                }
            }
            return Math.min(count, 3);  // Cap the score at 3
        }

        private static int getSpecialCharScore(String password) {
            int count = 0;
            for (char c : password.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    count++;
                }
            }
            return Math.min(count, 3);  // Cap the score at 3
        }
    }


