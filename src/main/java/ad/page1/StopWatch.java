package ad.page1;

/**
 * Created by abw286 on 06.10.2016.
 *
 */
class StopWatch {
    private long timeStart;
    private long timeEnd;

    void start(){
        timeStart = System.currentTimeMillis();
    }

    long stop(){
        timeEnd = System.currentTimeMillis();
        return getEndTime();
    }

    long getActualTime(){
        return (System.currentTimeMillis()-timeStart);
    }

    long getEndTime(){
        return (timeEnd-timeStart);
    }
}
