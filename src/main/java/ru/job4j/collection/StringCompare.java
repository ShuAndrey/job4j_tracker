package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = Integer.compare(left.length(), right.length());
        int length = Math.min(left.length(), right.length());
        for (int index = 0; index < length; index++) {
            char charLeft = left.charAt(index);
            char charRight = right.charAt(index);
            if (charLeft != charRight) {
                result = Character.compare(charLeft, charRight);
                break;
            }
        }
        return result;
    }
}