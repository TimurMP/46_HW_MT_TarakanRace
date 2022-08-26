package telar.tarakan.launcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLauncher {

    public int amountOfTarakans() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Amount of tarakans to release: ");
        return Integer.parseInt(bufferedReader.readLine());
    }

    public int amountOfLaps() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Amount of Laps: ");
        return Integer.parseInt(bufferedReader.readLine());
    }


}
