package lab2_1;

import org.junit.Assert;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

    private int[] seqOne = {5};
    private int[] seqTwo = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void existingElementInOneElementSeq() {
        SearchResult searchResult = BinarySearch.search(5, seqOne);
        Assert.assertEquals(searchResult.getPosition(), 0);
    }

    @Test
    public void notExistingElementInOneElementSeq() {
        SearchResult searchResult = BinarySearch.search(3, seqOne);
        Assert.assertEquals(searchResult.getPosition(), -1);
    }

    @Test
    public void checkIfFirstElementIsInSeq() {
        SearchResult searchResult = BinarySearch.search(0, seqTwo);
        Assert.assertEquals(searchResult.getPosition(), 0);
    }

    @Test
    public void checkIfLastElementIsInSeq() {
        SearchResult searchResult = BinarySearch.search(seqTwo[seqTwo.length - 1], seqTwo);
        Assert.assertEquals(searchResult.getPosition(), seqTwo.length - 1);
    }

    @Test
    public void checkIfMiddleElementIsInSeq() {
        SearchResult searchResult = BinarySearch.search(seqTwo[seqTwo.length / 2 - 1], seqTwo);
        Assert.assertEquals(searchResult.getPosition(), seqTwo.length / 2 - 1);
    }

    @Test
    public void checkIfAnyElementIsInSeq() {
        SearchResult searchResult = BinarySearch.search(1000, seqTwo);
        Assert.assertEquals(searchResult.getPosition(), -1);
    }
}
