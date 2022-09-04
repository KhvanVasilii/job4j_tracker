package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String message) {
        super(message);
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                return rsl;
            }
        }
        throw new ElementNotFoundException("Element not found");
    }

    public static void main(String[] args) {
        String[] arr = {"test1", "test2", "test4", "test5"};
        try {
            System.out.println("Index = " + indexOf(arr, "test2"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
