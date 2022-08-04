import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analog2DigitalConverter {

    public List<Integer> analog2Digital(List<Integer> uInputs, int sensorMin, int sensorMax, int minAmp , int maxAmp){

     //   List<Integer> digital = uInputs.stream().filter(input -> validateSensorRange(input,sensorMin,sensorMax)==true)
     //                                               .map(y->convertToAmps(y,sensorMin,sensorMax,minAmp,maxAmp)).collect(Collectors.toList());

        List<Integer> digital  = new ArrayList<>();
         for(Integer input: uInputs) {
             if(validateSensorRange(input,sensorMin,sensorMax)) {
                 throw new IllegalArgumentException("value not in Range");
             }
             int digi = convertToAmps(input,sensorMin,sensorMax,minAmp,maxAmp);
             digital.add(digi);
         }
       return digital;
    }

    public boolean validateSensorRange(int uInput,int sensorMin,int sensorMax){
        return (uInput< sensorMin || uInput >sensorMax);
    }

    public int convertToAmps(int uInput ,int sensorMin, int sensorMax,int minAmp ,int maxAmp) {
        return Math.round(
                ((uInput-sensorMin) * (maxAmp-minAmp))/(sensorMax-sensorMin)+minAmp);
    }

    public static void main(String[] args) {

    }
}
