package ad.helper;

/**
 * Created by abw286 on 06.10.2016.
 *
 */
public class StopWatch {
    private long timeStart;
    private long timeEnd;

    public void start(){
        timeStart = System.currentTimeMillis();
    }

    public String stop(){
        timeEnd = System.currentTimeMillis();
        return getEndTime();
    }

    public long getActualTime(){
        return (System.currentTimeMillis()-timeStart);
    }

    public String getEndTime(){
        long runtime = timeEnd-timeStart;
        String output = "error";
        if (runtime < 1000) {
            output = runtime + " ms";
        }else {
            if (runtime > 1000) {
                output = runtime/1000 + " sec";
            }
            if (runtime > 1000 * 60) {
                    output = runtime/1000 * 60 + " min";
            }
        }
        return (output);
    }
}
