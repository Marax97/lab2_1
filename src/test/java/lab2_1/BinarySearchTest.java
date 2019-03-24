package lab2_1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

    private int[] seqOne = {5};
    private int[] seqTwo = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void existingElementInOneElementSeq() {
        SearchResult searchResult = BinarySearch.search(seqOne[0], seqOne);
        assertThat(searchResult.getPosition(), is(equalTo(0)));
    }

    @Test
    public void notExistingElementInOneElementSeq() {
        SearchResult searchResult = BinarySearch.search(3, seqOne);
        assertThat(searchResult.getPosition(), is(equalTo(-1)));
    }

    @Test
    public void checkIfFirstElementIsInSeq() {
        SearchResult searchResult = BinarySearch.search(seqTwo[0], seqTwo);
        assertThat(searchResult.getPosition(), is(equalTo(0)));
    }

    @Test
    public void checkIfLastElementIsInSeq() {
        SearchResult searchResult = BinarySearch.search(seqTwo[seqTwo.length - 1], seqTwo);
        assertThat(searchResult.getPosition(), is(equalTo(seqTwo.length - 1)));
    }

    @Test
    public void checkIfMiddleElementIsInSeq() {
        SearchResult searchResult = BinarySearch.search(seqTwo[seqTwo.length / 2 - 1], seqTwo);
        assertThat(searchResult.getPosition(), is(equalTo(seqTwo.length / 2 - 1)));
    }

    @Test
    public void checkIfAnyElementIsInSeq() {
        SearchResult searchResult = BinarySearch.search(1000, seqTwo);
        assertThat(searchResult.getPosition(), is(equalTo(-1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnEmptySeq() {
        int[] empty = {};
        BinarySearch.search(0, empty);
    }
}
