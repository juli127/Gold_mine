package com.gmail.kramarenko104.goldmine;

public class RunApp {

    static final int START_WORKERS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {

/*
Gold Mine. есть шахта на 1000 золота.
и есть бараки, которые производят 1 рабочего в 10 сек.
Рабочий добывает 3 золота / сек. Изначально есть 5 рабочих.
Программа заканчивается , когда в шахте становиться <= 0 золота.
Все действия выводить в консоль в понятном и читабельном виде.
 */
	GoldenMine goldenMine = new GoldenMine(1000);
        Barack barack = new Barack(START_WORKERS_COUNT, goldenMine);

        new Thread(barack).start();
    }
}
