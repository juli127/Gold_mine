package com.gmail.kramarenko104.goldmine;

import java.util.concurrent.TimeUnit;

public class Barack implements Runnable {

    private int startWorkersCount;
    private GoldenMine goldenMine;

    public Barack(int startWorkersCount, GoldenMine goldenMine) {
        this.startWorkersCount = startWorkersCount;
        this.goldenMine = goldenMine;
    }

    // бараки производят 1 рабочего в 10 сек
    @Override
    public void run() {

        for (int i = 0; i < startWorkersCount; i++) {
            Worker worker = new Worker(goldenMine, Integer.toString(i));
            new Thread(worker).start();
        }

        while (goldenMine.getGold() > 0) {
            try {
                TimeUnit.SECONDS.sleep(10);
                if (goldenMine.getGold() > 0) {
                    System.out.println("Barack creates 1 worker in 10 second...");
                    Worker worker = new Worker(goldenMine, Integer.toString(++startWorkersCount));
                    new Thread(worker).start();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Barack STOPS to create workers ...");
    }
}
