package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book headFirst = new Book(200, "Изучаем Java");
        Book effectiveJava = new Book(300, "Java, Эффективное программирование");
        Book thinkingInJava = new Book(400, "Философия Java");
        Book cleanCode = new Book(250, "Clean code");
        Book[] books = {headFirst, effectiveJava, thinkingInJava, cleanCode};
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPages());
        }
        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPages());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println(books[index].getName() + " - " + books[index].getPages());
            }
        }
    }
}
