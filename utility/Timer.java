package utility;

public class Timer {
    // To use:
    //    Timer t = new Timer();
    //    t.start();
    //    t.end();
    double startTime = 0;
    double endTime = 0;

    public void start() {
        startTime = System.nanoTime();
    }

    public void end() {
        double time = (System.nanoTime() - startTime) * 0.000000001;
        System.out.println(time + " seconds");
    }
}
