package com.gmail.kramarenko104.goldmine;

import java.util.concurrent.TimeUnit;

// Рабочий добывает 3 золота / сек.
public class Worker implements Runnable {

    private GoldenMine goldenMine;
    private String name;

    public Worker(GoldenMine goldenMine, String name) {
        this.goldenMine = goldenMine;
        this.name = name;
        System.out.println("New Worker #" + name + " was created  ++++++++++++++ ");
    }

    @Override
    public void run() {
        int remainedGold = 0;
        do {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("Worker #" + name + " tries to mine 3 golds in 1 second...");

            synchronized (goldenMine) {
                remainedGold = goldenMine.getGold();
                if (remainedGold > 0) {
                    goldenMine.mineGold(3);
                    remainedGold = goldenMine.getGold();
                    System.out.println("Worker #" + name + " MINED 3 golds ----------------");
                    System.out.println("As result, it remains " + remainedGold + " gold in Gold mine \n");
                }
            }
        } while (remainedGold > 0);
        System.out.println("THERE ISN'T ANY GOLD in the gold mind...Worker #" + name + " STOPS to work !!!!!!!!!" );
    }
}
