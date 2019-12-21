package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("a1", "t1", 2000, "a1t1"));
        bookSet.add(new Book("a2", "t2", 2001, "a2t2"));
        bookSet.add(new Book("a3", "t3", 1978, "a3t3"));
        bookSet.add(new Book("a4", "t4", 2004, "a4t4"));
        bookSet.add(new Book("a5", "t5", 1234, "a5t5"));
        //When
        MedianAdapter adapter = new MedianAdapter();
        int medianPublicationYear = adapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2000, medianPublicationYear);
    }
}
