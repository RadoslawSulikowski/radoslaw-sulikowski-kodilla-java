package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        Library libraryShallowCopy = null;
        Library libraryDeepCopy = null;
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("Title " + n, "Author " + n, LocalDate.now().minusDays(10 * n))));
        try {
            libraryShallowCopy = library.shallowCopy();
        } catch(CloneNotSupportedException e) {
            System.out.println("" + e);
        }
        try {
            libraryDeepCopy = library.deepCopy();
        } catch(CloneNotSupportedException e) {
            System.out.println("" + e);
        }
        //When
        Book bookToRemove = library.getBooks().stream()
                .filter(b -> b.getTitle().equals("Title 1"))
                .findFirst()
                .orElse(null);
        library.getBooks().remove(bookToRemove);
        //Then
        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, libraryShallowCopy.getBooks().size());
        Assert.assertEquals(5, libraryDeepCopy.getBooks().size());

        System.out.println("Library Books");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
        System.out.println("\nLibrary Shallow Copy Books");
        for (Book book : libraryShallowCopy.getBooks()) {
            System.out.println(book);
        }
        System.out.println("\nLibrary Deep Copy Books");
        for (Book book : libraryDeepCopy.getBooks()) {
            System.out.println(book);
        }
    }
}
