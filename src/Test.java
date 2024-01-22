import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
      int [][] tab = new int[10][10];
      tab [1][3] = 7;

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
}
