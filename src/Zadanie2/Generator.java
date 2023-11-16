package Zadanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        int ileLiczb = 10;
        Random random = new Random();
        Path path = Paths.get("szymonBartkowiakPS1.txt");
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(ileLiczb));

        for(int i = 0; i < ileLiczb; i++) {
            list.add(random.nextInt(1000) + " " + random.nextInt(1000));
        }

        try {
            Files.write(path,list, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
