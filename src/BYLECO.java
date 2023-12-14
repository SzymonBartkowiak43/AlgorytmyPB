



public class BYLECO {
    public static void main(String[] args) {
        int n = 10;
        int liczbaSpacji = n-1;
        int liczbaGwiazdek = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < liczbaSpacji; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < liczbaGwiazdek; j++) {
                System.out.print("*");
            }
            liczbaGwiazdek+=2;
            liczbaSpacji--;
            System.out.println();
        }
    }
}
