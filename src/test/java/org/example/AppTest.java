package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest {

    App sut = new App();
    Map<Integer, Integer> books;

    @Before
    public void setup() {
        books = new HashMap<>();
    }

    @Test
    public void oneBook() {
        books.put(0, 1);
        books.put(1, 0);
        books.put(2, 0);
        books.put(3, 0);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(8.00, result, .01);
    }

    @Test
    public void threeDistinctBooks() {
        books.put(0, 1);
        books.put(1, 0);
        books.put(2, 1);
        books.put(3, 1);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(21.6, result, .01);
    }

    @Test
    public void fiveDistinctBooks() {
        books.put(0, 1);
        books.put(1, 1);
        books.put(2, 1);
        books.put(3, 1);
        books.put(4, 1);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(30.00, result, .01);
    }

    @Test
    public void fiveBooksFourDistinct() {
        books.put(0, 1);
        books.put(1, 1);
        books.put(2, 1);
        books.put(3, 2);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(33.6, result, .01);
    }

    @Test
    public void fiveBooksThreeDistinct() {
        books.put(0, 2);
        books.put(1, 1);
        books.put(2, 0);
        books.put(3, 2);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(36.8, result, .01);
    }

    @Test
    public void sixBooksFourDistinct() {
        books.put(0, 2);
        books.put(1, 0);
        books.put(2, 1);
        books.put(3, 2);
        books.put(4, 1);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(40.8, result, .01);
    }

    // the doozey example scenario!
    @Test
    public void eightBooksFiveDistinct() {
        books.put(0, 2);
        books.put(1, 2);
        books.put(2, 2);
        books.put(3, 1);
        books.put(4, 1);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(51.2, result, .01);
    }

    @Test
    public void thirteenBooksFiveDistinct() {
        books.put(0, 3);
        books.put(1, 3);
        books.put(2, 3);
        books.put(3, 2);
        books.put(4, 2);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(81.2, result, .01);
    }

    @Test
    public void seventeenBooksThreeDistinct() {
        books.put(0, 0);
        books.put(1, 0);
        books.put(2, 5);
        books.put(3, 5);
        books.put(4, 7);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(124.00, result, .01);
    }

    // also contains the 5/3 to 4/4 scenario
    @Test
    public void thirtyoneBooksFiveDistinct() {
        books.put(0, 7);
        books.put(1, 7);
        books.put(2, 7);
        books.put(3, 5);
        books.put(4, 5);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(192.8, result, .01);
    }

    @Test
    public void tenBooksOneDistinct() {
        books.put(0, 10);
        books.put(1, 0);
        books.put(2, 0);
        books.put(3, 0);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(80.00, result, .01);
    }

    @Test
    public void thirtysixBooksFourDistinct() {
        books.put(0, 10);
        books.put(1, 10);
        books.put(2, 8);
        books.put(3, 8);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        Assert.assertEquals(235.20, result, .01);
    }

}
