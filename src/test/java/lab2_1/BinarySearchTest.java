package lab2_1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

    @Test
    public void checkIfExistingElementInOneElementSeqReturn0() {
        int[] seqOne = {5};
        SearchResult searchResult = BinarySearch.search(5, seqOne);
        assertThat(searchResult.getPosition(), is(equalTo(0)));
    }

    @Test
    public void checkIfNotExistingElementInOneElementSeqReturnNegativeOne() {
        int[] seqOne = {5};
        SearchResult searchResult = BinarySearch.search(3, seqOne);
        assertThat(searchResult.getPosition(), is(equalTo(-1)));
    }

    @Test
    public void checkIfFirstElementIsInSeqAtFirstPosition() {
        int[] seqTwo = {2, 3, 5, 6, 7, 8, 9, 10};
        SearchResult searchResult = BinarySearch.search(seqTwo[0], seqTwo);
        assertThat(searchResult.getPosition(), is(equalTo(0)));
    }

    @Test
    public void checkIfLastElementIsInSeqAtLastPosition() {
        int[] seqTwo = {0, 1, 2, 3, 4, 5, 6, 10};
        SearchResult searchResult = BinarySearch.search(seqTwo[seqTwo.length - 1], seqTwo);
        assertThat(searchResult.getPosition(), is(equalTo(seqTwo.length - 1)));
    }

    @Test
    public void checkIfMiddleElementIsInSeqAtMiddlePosition() {
        int[] seqTwo = {0, 1, 2, 3, 4, 5, 23, 42, 13};
        SearchResult searchResult = BinarySearch.search(seqTwo[(seqTwo.length - 1) / 2], seqTwo);
        assertThat(searchResult.getPosition(), is(equalTo((seqTwo.length - 1) / 2)));
    }

    @Test
    public void checkIfNotExistingElementReturnPositionNegativeOne() {
        int[] seqTwo = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SearchResult searchResult = BinarySearch.search(1000, seqTwo);
        assertThat(searchResult.getPosition(), is(equalTo(-1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnEmptySeq() {
        int[] empty = {};
        BinarySearch.search(0, empty);
    }

    /*
     * testy_v3 odp Lepiej przeprowadzic test dla elementu o jeden mniejszemu niż środkowy. Pozwoli to na przejście
     * wiekszej liczby gałęzi (skrajna wartość) niż w przypdku sprawdzania pierwszego elementu. Wystąpi tylko dla
     * sekwencji z parzystą liczbą elementów.
     */
    @Test
    public void checkElementAtPossitionLowerByOneThenMiddleElement() {
        int[] seq = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        SearchResult searchResult = BinarySearch.search((seq.length - 1) / 2 - 1, seq);
        assertThat(searchResult.getPosition(), is(equalTo((seq.length - 1) / 2 - 1)));
    }
}
