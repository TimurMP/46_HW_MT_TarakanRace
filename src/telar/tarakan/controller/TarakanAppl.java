package telar.tarakan.controller;

import telar.tarakan.launcher.GameLauncher;
import telar.tarakan.model.Tarakan;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TarakanAppl {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, Long> time = new HashMap<>();
        GameLauncher gameLauncher = new GameLauncher();
        int tarakansAmount = gameLauncher.amountOfTarakans();
        int lapsAmount = gameLauncher.amountOfLaps();
        System.out.println("\nLet the race begin!\n");


        Tarakan[] tarakans = new Tarakan[tarakansAmount];
        Thread[] threads = new Thread[tarakans.length];
        for (int i = 0; i < tarakans.length; i++) {
            tarakans[i] = new Tarakan("Tarakan " + (i + 1), lapsAmount);
            threads[i] = new Thread(tarakans[i]);
            threads[i].setName("Tarakan " + (i + 1));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        for (int i = 0; i < threads.length; i++) {
            time.put(threads[i].getName(), tarakans[i].getFinishTime());
        }

        System.out.println("\nCongratulations, " + winnerFinder(time).toUpperCase() + " WON THE RACE");


    }


    public static String winnerFinder(Map<String, Long> finished) {

        long value = Long.MAX_VALUE;
        for (Map.Entry<String, Long> stringLongEntry : finished.entrySet()) {
            if (stringLongEntry.getValue() < value) {
                value = stringLongEntry.getValue();
            }
        }
        long v = value;

        return finished.entrySet().stream()
                .filter(e -> e.getValue().equals(v))
                .map(Map.Entry::getKey)
                .findAny().get();
    }
}
