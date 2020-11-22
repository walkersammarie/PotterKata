package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

    /*  The description of this kata can be found at https://codingdojo.org/kata/Potter/. */

    /* This method takes the book order as a map, with each key being each of the 5 books
     and the value being the number of copies of that book they have ordered. It then
     calculates the order total, incorporating discounts for different sets of books. My
     approach was to make subsets (in the form of a list) of each book set so the discounts
     could be calculated more easily. The previous set is stored to do checks for the edge
     cases. */

    // might eventually change this to use BigDecimals instead so there aren't rounding errors
    public double calculateTotal(Map<Integer, Integer> order) {
        // final cost
        double cost = 0.00;

        // current single set of books and the count of books
        List<Integer> currentSet;
        int currentBookCount = 0;
        // previous single set of books and the count of books
        List<Integer> previousSet;
        int previousBookCount = 0;

        // total number of books in the order
        int totalBooks = order.get(0) + order.get(1) + order.get(2) + order.get(3) + order.get(4);

        do {

            // clear out currentSet
            currentSet = new ArrayList<>();

            //go through each key-value pair in the order and add/subtract to currentSet/order to make subtotals
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i) > 0) {
                    // if there's more than 1 copy of that book in their order, add 1 to the currentSet
                    currentSet.add(1);
                    // subtract 1 from the total books
                    totalBooks--;
                    // put new count value (minus 1 that we just took out) back into the map
                    int newBookCount = order.get(i) - 1;
                    order.put(i, newBookCount);
                } else {
                    // if there's not a copy of that book in their order, add 0 to the currentSet
                    currentSet.add(0);
                }
            }

            // calculate cost of the current set and add to total
            cost += calculateSetSubTotal(currentSet);

            // calculate book count for this set
            currentBookCount = currentSet.get(0) + currentSet.get(1) + currentSet.get(2) + currentSet.get(3) + currentSet.get(4);

            // only discount that's cheaper is a set of 4 & 4 instead of set of 5 & 3
            // subtract the extra discount for a 4 & 4 set instead
            if (previousBookCount == 5 && currentBookCount == 3) {
                cost -= .40;
            }

            // set previous set
            previousSet = currentSet;
            previousBookCount = previousSet.get(0) + previousSet.get(1) + previousSet.get(2) + previousSet.get(3) + previousSet.get(4);

        } while (totalBooks > 0);

        return cost;
    }

    // this method takes in a single set of books and calculates their subtotal based on the outlined discounts
    public double calculateSetSubTotal(List<Integer> bookSet) {
        double result = 0.00;
        int totalBooks = bookSet.get(0) + bookSet.get(1) + bookSet.get(2) + bookSet.get(3) + bookSet.get(4);

        if (totalBooks == 5) {
            result = 5 * 8 * .75;
        } else if (totalBooks == 4) {
            result = 4 * 8 * .8;
        } else if (totalBooks == 3) {
            result = 3 * 8 * .9;
        } else if (totalBooks == 2) {
            result = 2 * 8 * .95;
        } else if (totalBooks == 1) {
            result = 1 * 8;
        }
        return result;
    }

}
