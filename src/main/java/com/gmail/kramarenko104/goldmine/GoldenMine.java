package com.gmail.kramarenko104.goldmine;

public class GoldenMine {

    private volatile int goldResource;

    public GoldenMine(int goldResource) {
        this.goldResource = goldResource;
    }

    public synchronized int getGold() {
       return goldResource;
    }

    public synchronized void mineGold(int gold) {
        if (goldResource >= gold){
            goldResource -= gold;
        }else
        {
            goldResource = 0;
        }
    }
}
