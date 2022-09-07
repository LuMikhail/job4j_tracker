package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book robin = new Book("Robin Hood", 250);
        Book freckles = new Book("Freckles", 105);
        Book cleanCode =  new Book("Clean code", 1105);
        Book headFirst = new Book("Head First Java", 580);
        Book[] library = new Book[4];
        library[0] = robin;
        library[1] = freckles;
        library[2] = cleanCode;
        library[3] = headFirst;
        System.out.println("List of books:");
        for (int l = 0; l < library.length; l++) {
            Book lib = library[l];
            System.out.println(lib.getName() +  " number of pages " + lib.getPage());
        }
        System.out.println();
        System.out.println("New List of books swapped places startOnAnd:");
        Book temp = new Book(null, 0);
        temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        for (int i = 0; i < library.length; i++) {
            Book lib = library[i];
            System.out.println(lib.getName() + " number of pages " + lib.getPage());
        }
        System.out.println();
        System.out.println("Find out \"Clean code\"");
        for (int i = 0; i < library.length; i++) {
            Book lib = library[i];
            if (lib.getName() == "Clean code")  {
            System.out.println(lib.getName() + " number of pages " + lib.getPage());
            }
            }
    }
}
