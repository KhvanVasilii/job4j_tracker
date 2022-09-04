package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException();
    }

    public static void main(String[] args) {
        String[] arr = {"test1", "test2", "test4", "test5"};
        try {
            System.out.println("Index = " + indexOf(arr, "test5"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
