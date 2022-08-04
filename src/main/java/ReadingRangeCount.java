import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReadingRangeCount {
    int []  data = {3,3,5,4,10,11,12};

    public Map<String,String> countGivenRange(int start , int stop) {
        long count =0;
        Map<String,String> range = new HashMap<>();
        List<Integer> intList = Arrays.stream(data).boxed().collect(Collectors.toList());
        if(intList.contains(start) && intList.contains(stop)) {
            for(int i=start;i<=stop;i++) {
                if(intList.contains(i)) {
                    int dataConunt =i;
                    long seqCount = Arrays.stream(data).filter(d->d==(dataConunt)).count();
                    count=count+seqCount;
                } else {
                    range.put(start +"-"+stop, "Not in Range");
                    return range;
                }
            }
            range.put(start +"-"+stop,String.valueOf(count));
            return range;
        }

        range.put(start +"-"+stop,"No match found in the reading");
        return range;
    }
}
