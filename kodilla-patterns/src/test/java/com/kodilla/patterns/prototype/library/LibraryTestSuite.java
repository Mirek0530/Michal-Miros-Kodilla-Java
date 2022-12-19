package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("My library");
        Book orderOfThePhoenix = new Book("Order of the Phoenix", "J.K. Rowling", LocalDate.of(2003,6,21));
        Book halfBloodPrince = new Book("Half-Blood Prince", "J.K. Rowling", LocalDate.of(2005,7,16));
        Book deathlyHallows = new Book("Deathly Hallows", "J.K. Rowling", LocalDate.of(2007,7,21));

        library.add(orderOfThePhoenix);
        library.add(halfBloodPrince);
        library.add(deathlyHallows);

        Library libraryShallowClone = null;
        try {
            libraryShallowClone = library.shallowCopy();
            libraryShallowClone.setName("Shallow copied library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library libraryDeepClone = null;
        try {
            libraryDeepClone = library.deepCopy();
            libraryDeepClone.setName("Deep copied library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        //Then

        assertEquals(3, library.getBooks().size());
        assertEquals(3, libraryShallowClone.getBooks().size());
        assertEquals(3, libraryDeepClone.getBooks().size());
        assertEquals(libraryShallowClone.getBooks(), library.getBooks());
        assertEquals(libraryDeepClone.getBooks(), library.getBooks());
    }
}
