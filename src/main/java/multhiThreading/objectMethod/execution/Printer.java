package multhiThreading.objectMethod.execution;

import multhiThreading.util.random.RandomBetween;

import java.util.Timer;
import java.util.TimerTask;

public class Printer {

    final private RandomBetween timeRandom;
    private final String name;
    private boolean isPrint;
    private Storage storage;
    private Design design;

    public Printer(int minTime, int maxTime, String name, Storage storage) {
        this.timeRandom = new RandomBetween(minTime, maxTime);
        this.name = name;
        this.isPrint = false;
        this.storage = storage;
    }

    public void print(Design design) {
        System.out.printf("Принтер {%s} вызван...\n", this.name);
        if (isWork()) print_busy();
        if (!isWork()) print_run(design);
        System.out.printf("Принтер {%s} отработал вызов...\n", this.name);
    }

    private boolean isWork() {
        return this.isPrint;
    }

    private void print_run(Design design) {
        System.out.printf("Принтер {%s} запускается...\n", this.name);
        this.isPrint = true;
        this.design = design;

        Timer timer = new Timer();
        TimerTask timerTask = createTimerTask();
        timer.schedule(timerTask, timeRandom.newRandomValue());

        System.out.printf("Принтер {%s} запущен на {%.2fс}...\n", this.name, timeRandom.getRandomValue() * 0.01f);
    }

    private void print_busy() {
        System.out.printf("Принтер {%s} занят...\n", this.name);
    }

    private TimerTask createTimerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                finishPrint();
            }
        };
    }

    private void finishPrint() {
        System.out.printf("Принтер {%s} закончил печатать...\n", this.name);
        Printed printed = new Printed(design);
        storage.add(printed);
    }
}
