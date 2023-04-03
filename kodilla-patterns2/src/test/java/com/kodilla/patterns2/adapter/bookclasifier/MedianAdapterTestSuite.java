package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclassifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();

        bookSet.add(new Book("Dylan Murphy", "Wolf of the mountains", 2003, "0001"));
        bookSet.add(new Book("Phoebe Pearson", "Slaves of dreams", 2012, "0002"));
        bookSet.add(new Book("Morgan Walsh", "Obliteration of heaven", 2001, "0003"));
        bookSet.add(new Book("Aimee Murphy", "Rejecting the night", 2015, "0004"));
        bookSet.add(new Book("Ryan Talley", "Gangsters and kings", 2007, "0005"));
        bookSet.add(new Book("Madelynn Carson", "Unity without duty", 2007, "0006"));
        bookSet.add(new Book("Giancarlo Guerrero", "Enemies of eternity", 2009, "0007"));

        MedianAdapter adapter = new MedianAdapter();

        //When
        int result = adapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2007, result);
    }
}
