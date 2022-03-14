package ru.job4j.pojo;

public class Book {
    private int pages;
    private String name;

    public Book(int pages, String name) {
        this.pages = pages;
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
