package ss4_class_object.exercise.StopWatch;

public class ClassStopWatch {
    private long startTime;
    private long endTime;

    public ClassStopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    long start() {
        return this.startTime = System.currentTimeMillis();
    }

    long stop() {
        return this.endTime = System.currentTimeMillis();
    }

    long getStartTime() {
        return this.startTime;
    }

    long getEndTime() {
        return this.endTime;
    }

    public long getElapsedTime() {
        return this.endTime-this.startTime;
    }
}
