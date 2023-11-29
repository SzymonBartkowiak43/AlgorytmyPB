public class BYLECO {
    public static int janek = 0;
    public static void main(String[] args) {
        System.out.println(janek);
        f2(5);
        System.out.println(janek);
    }
    public static void f2(int n) {
        janek++;
        if(n == 1)
            return;
        for(int i=1; i <=3;i++) {
            f2(n-1);
        }
    }
}
