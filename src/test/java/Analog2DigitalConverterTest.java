import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Analog2DigitalConverterTest {

    Analog2DigitalConverter analog2DigitalConverter = new Analog2DigitalConverter();
    boolean actualResult;
    @Test
    public void outOfRangeInput() {
        actualResult = analog2DigitalConverter.validateSensorRange(8000,0,4094);
        assertTrue(actualResult);
    }

    @Test
    public void outOfRangeInput_2() {
        actualResult = analog2DigitalConverter.validateSensorRange(-8000,0,4094);
        assertTrue(actualResult);
    }
    @Test
    public void outOfRangeInput_3() {
        actualResult = analog2DigitalConverter.validateSensorRange(3000,0,1023);
        assertTrue(actualResult);
    }

    @Test
    public void outOfRangeInput_4() {
        actualResult = analog2DigitalConverter.validateSensorRange(-3000,0,1023);
        assertTrue(actualResult);
    }

    @Test
    public void convertToAmps_() {
        int actualResult = analog2DigitalConverter.convertToAmps(1000,0,4094,0,20);
        assertEquals(4,actualResult);
    }

    @Test
    public void convertToAmps_2() {
        int actualResult = analog2DigitalConverter.convertToAmps(600,0,1023,-20,20);
        assertEquals(3,actualResult);
    }

    @Test
    public void analog2Digital_1() {
        List<Integer> bitValues_12 = new ArrayList<>();
        bitValues_12.add(1000);
        bitValues_12.add(2000);
        bitValues_12.add(3000);
        bitValues_12.add(4000);
        List<Integer> actualResult = analog2DigitalConverter.analog2Digital(bitValues_12,0,4094,0,10);
       assertTrue(actualResult.size()==4);

    }

    @Test
    public void analog2Digital_2() {
        List<Integer> bitValues_12 = new ArrayList<>();
        bitValues_12.add(100);
        bitValues_12.add(200);
        bitValues_12.add(300);
        bitValues_12.add(400);
        List<Integer> actualResult = analog2DigitalConverter.analog2Digital(bitValues_12,0,1023,-15,15);
        assertTrue(actualResult.size()==4);

    }

}
