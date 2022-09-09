package ss4_class_object.excercise;

import java.util.Scanner;

public class StopWatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    public StopWatch() {
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }

    //thời gian chạy theo mili giây
    public long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = (System.currentTimeMillis() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }

    //thời gian chạy theo giây
    public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        } else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }
}
class Main{
    public static void main(String[] args) {

    }
}
