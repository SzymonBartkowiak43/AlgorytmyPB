public class BYLECO {
    public static void main(String[] args) {
        int n = 16;
        int suma = 0;

        for(int i=1;i<=n;i*=2) {

           for(int j =1; j<=i;j++) {
               suma++;

           }
        }
        System.out.println(suma);
    }
}
