package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if(titleFragment.length() < 3){
            return bookList;
        }
        List<Book> listOfBooksFromDB = this.libraryDatabase.listBooksWithCondition(titleFragment);
        if(listOfBooksFromDB.size() > 20){
            return bookList;
        }
        return listOfBooksFromDB;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser){

        return this.libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}