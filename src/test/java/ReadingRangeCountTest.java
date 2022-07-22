import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class ReadingRangeCountTest {
    ReadingRangeCount readingRangeCount = new ReadingRangeCount();

    @Test
    public void countGivenRangeTest_invalid_startRange() throws Exception {
        Map<String,String> rangeOut = readingRangeCount.countGivenRange(2,10);
        assertThat(rangeOut.get("2-10"),containsString("No match found in the reading"));
    }

    @Test
    public void countGivenRangeTest_invalid_endRange() throws Exception {
        Map<String,String> rangeOut = readingRangeCount.countGivenRange(4,18);
        assertThat(rangeOut.get("4-18"),containsString("No match found in the reading"));
    }

    @Test
    public void countGivenRangeTest_invalid_Range() throws Exception {
        Map<String,String> rangeOut = readingRangeCount.countGivenRange(4,10);
        assertThat(rangeOut.get("4-10"),containsString("Not in Range"));
    }

    @Test
    public void countGivenRangeTest_valid_Range() throws Exception {
        Map<String,String> rangeOut = readingRangeCount.countGivenRange(4,5);
        assertEquals("2",rangeOut.get("4-5"));
    }
    @Test
    public void countGivenRangeTest_valid_Range_duplicate() throws Exception {
        Map<String,String> rangeOut = readingRangeCount.countGivenRange(3,5);
        assertEquals("4",rangeOut.get("3-5"));
    }

}
