import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String s, k;
        int[] e;
        Scanner sc = new Scanner(System.in);
        model m = new model();
        System.out.println("Message: ");
        s = m.readMessageFromInput(sc.nextLine());
        System.out.println("Key: ");
        k = m.readKeyFromInput(sc.nextLine());
        System.out.println("Encrypting");
        e = m.encryptMessage(s, k);
        System.out.println(e);
        System.out.println("Output to file: ");
        m.outputToFile(sc.nextLine(), e);
    }
}
