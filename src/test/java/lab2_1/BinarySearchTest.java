package lab2_1;

import org.junit.Assert;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

    private int[] seqOne = {5};

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

}
