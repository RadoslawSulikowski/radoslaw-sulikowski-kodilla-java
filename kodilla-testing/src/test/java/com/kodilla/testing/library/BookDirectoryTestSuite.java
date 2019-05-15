package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    private List<Book> generateListOfNBooks(int bokksQuantity){
        List<Book> listOfBooks = new ArrayList<>();
        for(int i = 0; i < bokksQuantity; i++){
            listOfBooks.add(new Book("Title" + i, "Author" + i, 1987 + i));
        }
        return listOfBooks;
    }

    @Test
    public void testListBookWithConditionReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> givenListOfBooks = new ArrayList<>();
        givenListOfBooks.add(new Book("Secrets of Alamo", "John Smith", 2008));
        givenListOfBooks.add(new Book("Secretaries and Directors", "Dilbert Michigan", 2012));
        givenListOfBooks.add(new Book("Secret life of programmers", "Steve Wolkowitz", 2016));
        givenListOfBooks.add(new Book("Secrets of Java", "Ian Tenewitch", 2010));

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(givenListOfBooks);

        //When
        List<Book> resultListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        Assert.assertEquals(4, resultListOfBooks.size());
    }

    @Test
    public void testListBookWithConditionMoreThan20(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> givenListOf0Books = generateListOfNBooks(0);
        List<Book> givenListOf15Books = generateListOfNBooks(15);
        List<Book> givenListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(givenListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(givenListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(givenListOf40Books);

        //When
        List<Book> resultListOf0Books = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> resultListOf15Books = bookLibrary.listBooksWithCondition("AnyTitle");
        List<Book> resultListOf40Books = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        Assert.assertEquals("0-sized list returned from DB - test failed", 0, resultListOf0Books.size());
        Assert.assertEquals("15-sized list returned from DB - test failed", 15, resultListOf15Books.size());
        Assert.assertEquals("40-sized list returned from DB - test failed", 0, resultListOf40Books.size());
    }

    @Test
    public void testListBookWithConditionShorterThan3(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> givenListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(givenListOf10Books);

        //When
        List<Book> resultListOfBooks = bookLibrary.listBooksWithCondition("An");

        //Then
        Assert.assertEquals(0, resultListOfBooks.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOf(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser userWithNoRentedBooks = new LibraryUser("No","RentedBooks", "PESELID1");
        LibraryUser userWithOneRentedBook = new LibraryUser("One","RentedBook", "PESELID2");
        LibraryUser userWithFiveRentedBooks = new LibraryUser("Five","RentedBooks", "PESELID3");

        List<Book> givenListNoRentedBooks = new ArrayList<>();
        List<Book> givenListOneRentedBook = generateListOfNBooks(1);
        List<Book> givenListFiveRentedBooks = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(userWithNoRentedBooks)).thenReturn(givenListNoRentedBooks);
        when(libraryDatabaseMock.listBooksInHandsOf(userWithOneRentedBook)).thenReturn(givenListOneRentedBook);
        when(libraryDatabaseMock.listBooksInHandsOf(userWithFiveRentedBooks)).thenReturn(givenListFiveRentedBooks);

        //When
        List<Book> resultListNoRentedBooks = bookLibrary.listBooksInHandsOf(userWithNoRentedBooks);
        List<Book> resultListOneRentedBook = bookLibrary.listBooksInHandsOf(userWithOneRentedBook);
        List<Book> resultListFiveRentedBooks = bookLibrary.listBooksInHandsOf(userWithFiveRentedBooks);

        //Then
        Assert.assertEquals("NoRentedBooks test failed", 0, resultListNoRentedBooks.size());
        Assert.assertEquals("OneRentedBook test failed", 1, resultListOneRentedBook.size());
        Assert.assertEquals("FiveRentedBooks test failed", 5, resultListFiveRentedBooks.size());
    }
}
