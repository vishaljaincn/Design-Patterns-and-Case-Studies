package org.example.java8practicequestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

class Book {

    private String bookName;
    private String author;
    private int bookId;
    private int rating;

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookId() {
        return bookId;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return rating == book.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rating);
    }

    Book(String bookName, String author, int bookId, int rating) {
        this.bookName = bookName;
        this.author = author;
        this.bookId = bookId;
        this.rating = rating;
    }


}

public class Streams3 {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<Book>();

        bookList.add(new Book("Harry Potter", "Harry", 1, 4));
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1, 5));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 2, 5));
        bookList.add(new Book("1984", "George Orwell", 3, 5));
        bookList.add(new Book("Pride and Prejudice", "Jane Austen", 4, 4));
        bookList.add(new Book("The Catcher in the Rye", "J.D. Salinger", 5, 4));
        bookList.add(new Book("The Hobbit", "J.R.R. Tolkien", 6, 5));
        bookList.add(new Book("Moby Dick", "Herman Melville", 7, 3));
        bookList.add(new Book("War and Peace", "Leo Tolstoy", 8, 4));
        bookList.add(new Book("The Odyssey", "Homer", 9, 5));
        bookList.add(new Book("Moby Dick", "Herman Melville", 7, 3));
        bookList.add(new Book("War and Peace", "Leo Tolstoy", 8, 4));
        bookList.add(new Book("The Adventures of Huckleberry Finn", "Mark Twain", 14, 5));
        bookList.add(new Book("Jane Eyre", "Charlotte Brontë", 15, 4));
        bookList.add(new Book("Jane Eyre", "Charlotte Brontë", 15, 4));

        // Q1: How do you filter a list of books to get unique ratings using HashSet in Java Streams?
        HashSet<Integer> uniqueRatings = new HashSet<>();

        List<Book> uniqueBooks = bookList.stream()
                .filter(book -> uniqueRatings.add(book.getRating()))
                .toList();

        uniqueBooks.forEach(i -> System.out.println(i.getBookName() + "  " + i.getRating()));

        System.out.println("---------------------------------------------------------------");

        // Q2: How can you use the distinct() method in Java Streams to filter out duplicate books based on custom equals and hashCode methods?
        bookList.stream()
                .distinct()
                .forEach(i -> System.out.println(i.getBookName()));

        System.out.println("---------------------------------------------------------------");

        // Q3: How can you limit the stream to get the first two unique authors' books using Java Streams?
        HashSet<String> uniqueAuthorsNames = new HashSet<>();
        List<Book> uniqueAuthors = bookList.stream()
                .filter(book -> uniqueAuthorsNames.add(book.getAuthor()))
                .limit(2)
                .toList();

        uniqueAuthors.forEach(i -> System.out.println(i.getBookName()));

        System.out.println("---------------------------------------------------------------");
    }

}
