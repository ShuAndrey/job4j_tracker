package ru.job4j.pojo;

public class Library {
    private static void loop(Book[] books) {
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " " + books[index].getPages());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 244);
        Book robinsonCrusoe = new Book("Robinson Crusoe", 731);
        Book harryPotter = new Book("Harry Potter", 682);
        Book lotr = new Book("The Lord Of The Rings", 848);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = robinsonCrusoe;
        books[2] = harryPotter;
        books[3] = lotr;
        loop(books);
        books[0] = lotr;
        books[3] = cleanCode;
        loop(books);
        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals("Clean Code")) {
                System.out.println(books[index].getName() + " " + books[index].getPages());
            }
        }
    }
}
