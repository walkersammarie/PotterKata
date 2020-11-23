package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    /*  The description of this kata can be found at https://codingdojo.org/kata/Potter/. */

    /* This method takes the book order as a map, with the keys being each of the 5 books
     and the value being the number of copies of that book they have ordered. It then
     calculates the order total, incorporating discounts for different sets of books. My
     approach was to make subsets (stored in a map) so the discounts could be calculated
     more easily. */

    // might eventually change this to use BigDecimals instead so there aren't rounding errors
    public double calculateTotal(Map<Integer, Integer> order) {
        // final cost
        double cost = 0.00;
        // number of subsets
        int subsets = numberOfSubsets(order);
        // try using a map to store it instead, key is subset, value is how many books in that set
        Map<Integer, Integer> subsetCounts = new HashMap<>();

        // create the map with the subset book counts
        for (int i = 0; i < subsets; i++) {
            int subsetCount = 0;
            //go through each key-value pair in the order and add/subtract to subsetCounts/order to make subtotals
            for (int j = 0; j < order.size(); j++) {
                if (order.get(j) > 0) {
                    // if there's more than 1 copy of that book in their order, add 1 to the currentSet
                    subsetCount++;
                    // put new count value (minus 1 that we just took out) back into the map
                    int newBookCount = order.get(j) - 1;
                    order.put(j, newBookCount);
                }
            }
            // add subset number and count to map
            subsetCounts.put(i, subsetCount);
        }


        // pass map to method to get back extra discounts for 5/3 to 4/4 sets
        cost -= checkForExtraDiscounts(subsetCounts);

        // add all subtotals to total
        for (Map.Entry<Integer, Integer> entry : subsetCounts.entrySet()) {
            cost += calculateSetSubTotal(entry.getValue());
        }

        return cost;
    }

    // method to calculate extra discounts for 5/3 sets
    public double checkForExtraDiscounts(Map<Integer, Integer> subsetCounts) {
        double discount = 0.00;

        // count of how many sets of 5 and 3 there are
        int fiveCount = 0;
        int threeCount = 0;

        for (Map.Entry<Integer, Integer> entry : subsetCounts.entrySet()) {
            if (entry.getValue() == 5) {
                fiveCount++;
            } else if (entry.getValue() == 3) {
                threeCount++;
            }
        }

        int extraDiscounts = 0;

        if (fiveCount >= threeCount) {
            extraDiscounts = threeCount;
        } else if (threeCount > fiveCount) {
            extraDiscounts = fiveCount;
        }

        discount = extraDiscounts * 0.40;

        return discount;
    }

    // this method takes in a single set of books and calculates their subtotal based on the outlined discounts
    public double calculateSetSubTotal(int books) {
        double result = 0.00;

        if (books == 5) {
            result = 5 * 8 * .75;
        } else if (books == 4) {
            result = 4 * 8 * .8;
        } else if (books == 3) {
            result = 3 * 8 * .9;
        } else if (books == 2) {
            result = 2 * 8 * .95;
        } else if (books == 1) {
            result = 1 * 8;
        }
        return result;
    }

    // takes the largest book count (how many subsets there will be) and returns it
    public int numberOfSubsets(Map<Integer, Integer> order) {
        int result = 0;
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i) > result) {
                result = order.get(i);
            }
        }
        return result;
    }

}
