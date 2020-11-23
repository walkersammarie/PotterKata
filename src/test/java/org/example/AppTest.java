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
        // 1 set of 1
        double actual = 1 * 8;
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void threeDistinctBooks() {
        books.put(0, 1);
        books.put(1, 0);
        books.put(2, 1);
        books.put(3, 1);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        // 1 set of 3
        double actual = 3 * 8 * .9;
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void fiveDistinctBooks() {
        books.put(0, 1);
        books.put(1, 1);
        books.put(2, 1);
        books.put(3, 1);
        books.put(4, 1);
        double result = sut.calculateTotal(books);
        // 1 set of 5
        double actual = 5 * 8 * .75;
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void fiveBooksFourDistinct() {
        books.put(0, 1);
        books.put(1, 1);
        books.put(2, 1);
        books.put(3, 2);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        // 1 set of 4, 1 set of 1
        double actual = 4 * 8 * .8 + 1 * 8;
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void fiveBooksThreeDistinct() {
        books.put(0, 2);
        books.put(1, 1);
        books.put(2, 0);
        books.put(3, 2);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        // 1 set of 3, 1 set of 2
        double actual = 3 * 8 * .9 + 2 * 8 * .95;
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void sixBooksFourDistinct() {
        books.put(0, 2);
        books.put(1, 0);
        books.put(2, 1);
        books.put(3, 2);
        books.put(4, 1);
        double result = sut.calculateTotal(books);
        // 1 set of 4, 1 set of 2
        double actual = 4 * 8 * .8 + 2 * 8 * .95;
        Assert.assertEquals(actual, result, .01);
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
        // 2 sets of 4
        double actual = 2 * (4 * 8 * .8);
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void thirteenBooksFiveDistinct() {
        books.put(0, 3);
        books.put(1, 3);
        books.put(2, 3);
        books.put(3, 2);
        books.put(4, 2);
        double result = sut.calculateTotal(books);
        // 1 set of 5, 2 sets of 4
        double actual = 1 * (5 * 8 * .75) + 2 * (4 * 8 * .8);
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void seventeenBooksThreeDistinct() {
        books.put(0, 0);
        books.put(1, 0);
        books.put(2, 5);
        books.put(3, 5);
        books.put(4, 7);
        double result = sut.calculateTotal(books);
        // 5 sets of 3, 2 sets of 1
        double actual = 5 * (3 * 8 * .9) + 2 * (1 * 8);
        Assert.assertEquals(actual, result, .01);
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
        // 3 sets of 5, 4 sets of 4
        double actual = 3 * (5 * 8 * .75) + 4 * (4 * 8 * .8);
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void tenBooksOneDistinct() {
        books.put(0, 10);
        books.put(1, 0);
        books.put(2, 0);
        books.put(3, 0);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        // 10 sets of 1
        double actual = 10 * (1 * 8);
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void thirtysixBooksFourDistinct() {
        books.put(0, 10);
        books.put(1, 10);
        books.put(2, 8);
        books.put(3, 8);
        books.put(4, 0);
        double result = sut.calculateTotal(books);
        // 8 sets of 4, 2 sets of 2
        double actual = 8 * (4 * 8 * .8) + 2 * (2 * 8 * .95);
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void descendingBooks() {
        books.put(0, 5);
        books.put(1, 4);
        books.put(2, 3);
        books.put(3, 2);
        books.put(4, 1);
        double result = sut.calculateTotal(books);
        // 3 sets of 4, 1 set of 2, 1 set of 1
        double actual = 3 * (4 * 8 * .8) + 1 * (2 * 8 * .95) + 1 * (1 * 8);
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void nineteenBooksFiveDistinct() {
        books.put(0, 7);
        books.put(1, 4);
        books.put(2, 4);
        books.put(3, 2);
        books.put(4, 2);
        double result = sut.calculateTotal(books);
        // 4 sets of 4, 3 sets of 1
        double actual = 4 * (4 * 8 * .8) + 3 * (1 * 8);
        Assert.assertEquals(actual, result, .01);
    }

    @Test
    public void subsets() {
        books.put(0, 5);
        books.put(1, 4);
        books.put(2, 9);
        books.put(3, 2);
        books.put(4, 1);
        int result = sut.numberOfSubsets(books);
        Assert.assertEquals(9, result);
    }

}
