import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println(4%3);
        String s, e;
        int k;
        Scanner sc = new Scanner(System.in);
        model m = new model();
        System.out.println("Message: ");
        s = m.readMessageFromInput(sc.nextLine());
        System.out.println("Key: ");
        k = m.readKeyFromInput(Integer.parseInt(sc.nextLine()));
        System.out.println("Encrypting");
        e = m.encryptMessage(s, k);
        System.out.println(e);
        System.out.println("Output to file: ");
        m.outputToFile(sc.nextLine(), e);
    }
}
