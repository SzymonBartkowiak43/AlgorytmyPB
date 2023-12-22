



public class BYLECO {
    public static void main(String[] args) {
        String pierwszy = "Kamil Kozak, polna 21";
        String drugi = "Marta Migdał, polna 33";

        int result = pierwszy.compareTo(drugi);

        if (result < 0) {
            System.out.println(drugi);
        } else if (result > 0) {
            System.out.println(pierwszy);
        }
    }
}
