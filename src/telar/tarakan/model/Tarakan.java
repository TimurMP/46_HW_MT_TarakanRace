package telar.tarakan.model;

import java.util.Random;

public class Tarakan implements Runnable {

    String name;
    int distance;

    long finishTime;

    public long getFinishTime() {
        return finishTime;
    }

    public Tarakan(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public void run() {
        System.out.println(name + " Started the race");
        for (int i = 0; i < distance; i++) {
            System.out.println(name + " running Lap " + (i + 1));
            try {
                Thread.sleep(sleep());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(name + " Finished the race!");
        finishTime = System.nanoTime();


    }


    private static int sleep() {
        Random random = new Random();
        int low = 2;
        int high = 5;
        high++;
        return random.nextInt(high - low) + low;
    }
}
